import { Component } from '@angular/core';
import { UiService } from '../../services/ui.service';
import { keycloak } from 'src/main';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isFullScreen: boolean = false;
  userInfo: any = keycloak.userInfo;

  constructor(protected uiService: UiService) {}

  ngOnInit() {
    this.userInfo.role = 'Parent';
    this.isFullScreen = document.fullscreenElement ? true : false;
    // Add fullscreen change event listener
    document.addEventListener('fullscreenchange', this.onFullscreenChange.bind(this));
  }

  ngOnDestroy() {
    // Remove fullscreen change event listener
    document.removeEventListener('fullscreenchange', this.onFullscreenChange.bind(this));
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
}
