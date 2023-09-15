import { Component } from '@angular/core';
import {
  ActivatedRoute,
  NavigationEnd,
  Router
} from '@angular/router';
import { filter } from 'rxjs/operators';
import { MenuItem } from '../../models/menu-item.model';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent {
  currentHoveredItem: MenuItem | null = null;
  currentActiveItemPath: string = '';

  menu: MenuItem[] = [
    {
      label: 'Home',
      path: '/dashboard',
      icon: 'fa-solid fa-house-chimney',
      color: '#E57676',
    },
    {
      label: 'Profile & Details',
      path: '/student-profile',
      icon: 'fa-solid fa-chalkboard-user',
      color: '#F3A533',
    },
    {
      label: 'Courses',
      path: '/courses',
      icon: 'fa-solid fa-book',
      color: '#59BBDE',
    },
    {
      label: 'Calendar',
      path: '/calendar',
      icon: 'fa-solid fa-calendar-days',
      color: '#575787',
    },
    {
      label: 'Academic & Attendance',
      path: '/dashboard/platform-management/create-school',
      icon: 'fa-solid fa-graduation-cap',
      color: '#E17DA5',
    },
    {
      label: 'Fees & Payments',
      path: '/fees',
      icon: 'fa-solid fa-money-check-dollar',
      color: '#67D293',
    },
  ];

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    //this.setFullPath();
    this.currentActiveItemPath = this.router.url;
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe(() => {
        //this.setFullPath();
        this.currentActiveItemPath = this.router.url;
      });
  }

  private setFullPath(): string {
    let fullPath = this.router.url;
    let queryParameters = this.activatedRoute.snapshot.queryParams;
    let fragment = this.activatedRoute.snapshot.fragment;

    // Adding query parameters
    if (Object.keys(queryParameters).length > 0) {
      fullPath += '?' + new URLSearchParams(queryParameters).toString();
    }

    // Adding fragment if it exists
    if (fragment) {
      fullPath += '#' + fragment;
    }

    return fullPath;
  }
  onMouseOver(item: any): void {
    this.currentHoveredItem = item;
  }

  onMouseOut(): void {
    this.currentHoveredItem = null;
  }
}
