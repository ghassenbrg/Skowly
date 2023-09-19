import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';
import { Component, ElementRef, HostListener, Renderer2 } from '@angular/core';
import { languagesList } from '../../constants/language.constant';
import { UiService } from '../../services/ui.service';
import { AuthenticationService } from './../../auth/auth.service';
import { SecurityRolesData } from './../../constants/security-role.constant';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  animations: [
    trigger('slideToggle', [
      state(
        'open',
        style({
          height: '*',
        })
      ),
      state(
        'closed',
        style({
          height: '0px',
        })
      ),
      transition('open <=> closed', [animate('100ms ease-in-out')]),
    ]),
  ],
})
export class HeaderComponent {
  isFullScreen: boolean = false;
  userInfo: any;
  selectedLang: string;
  supportedLanguages: any[] = languagesList;
  dropdowns: any = {
    userSectionOpen: false,
    languageOpen: false,
  };
  userRolesListSize: number;
  displayRoleSelectionDialog: boolean = false;

  constructor(
    private renderer: Renderer2,
    private el: ElementRef,
    protected uiService: UiService,
    private auth: AuthenticationService
  ) {
    this.userInfo = this.auth.getUserInfo();
    this.userInfo.role = SecurityRolesData[this.auth.getSelectedRole()]?.label;
    this.selectedLang = this.auth.getProfile() as string;
    this.userRolesListSize = this.auth.getRoles().length;
  }

  ngOnInit() {
    this.isFullScreen = document.fullscreenElement ? true : false;
    // Add fullscreen change event listener
    document.addEventListener(
      'fullscreenchange',
      this.onFullscreenChange.bind(this)
    );
  }

  ngOnDestroy() {
    // Remove fullscreen change event listener
    document.removeEventListener(
      'fullscreenchange',
      this.onFullscreenChange.bind(this)
    );
  }

  logout() {
    this.auth.logout('/');
  }

  changeLanguage(lang: string) {
    //this.selectedLang = lang;
    this.auth.setProfile(lang, true);
  }

  onFullscreenChange() {
    this.isFullScreen = document.fullscreenElement ? true : false;
  }

  toggleFullscreen() {
    if (!document.fullscreenElement) {
      this.openFullscreen();
      this.isFullScreen = true;
    } else {
      this.closeFullscreen();
      this.isFullScreen = false;
    }
  }

  openFullscreen() {
    if ((document.documentElement as any).requestFullscreen) {
      document.documentElement.requestFullscreen();
    } else if ((document.documentElement as any).mozRequestFullScreen) {
      /* Firefox */
      (document.documentElement as any).mozRequestFullScreen();
    } else if ((document.documentElement as any).webkitRequestFullscreen) {
      /* Chrome, Safari & Opera */
      (document.documentElement as any).webkitRequestFullscreen();
    } else if ((document.documentElement as any).msRequestFullscreen) {
      /* IE/Edge */
      (document.documentElement as any).msRequestFullscreen();
    }
  }

  closeFullscreen() {
    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if ((document as any).mozCancelFullScreen) {
      /* Firefox */
      (document as any).mozCancelFullScreen();
    } else if ((document as any).webkitExitFullscreen) {
      /* Chrome, Safari & Opera */
      (document as any).webkitExitFullscreen();
    } else if ((document as any).msExitFullscreen) {
      /* IE/Edge */
      (document as any).msExitFullscreen();
    }
  }

  @HostListener('document:click', ['$event'])
  handleDocumentClick(event: Event) {
    Object.keys(this.dropdowns).forEach((key) => {
      const dropdown = this.el.nativeElement.querySelector(`.${key}-dropdown`);
      if (dropdown && !dropdown.contains(event.target)) {
        this.closeDropdown(key);
      }
    });
  }

  toggleDropdown(dropdownVarName: string) {
    this.dropdowns[dropdownVarName] = !this.dropdowns[dropdownVarName];
    this.updateDropdownDisplay(dropdownVarName);
  }

  closeDropdown(dropdownVarName: string) {
    this.dropdowns[dropdownVarName] = false;
    this.updateDropdownDisplay(dropdownVarName);
  }

  updateDropdownDisplay(dropdownVarName: string) {
    const dropdownMenu = this.el.nativeElement.querySelector(
      `.${dropdownVarName}`
    );
    if (this.dropdowns[dropdownVarName]) {
      this.renderer.addClass(dropdownMenu, 'show');
    } else {
      this.renderer.removeClass(dropdownMenu, 'show');
    }
  }

  showDialog() {
    this.displayRoleSelectionDialog = !this.displayRoleSelectionDialog;
  }
}
