import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DashboardPageComponent } from './components/dashboard-page/dashboard-page.component';

import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { BadgeModule } from 'primeng/badge';
import { HeaderComponent } from './components/header/header.component';
import { TooltipModule } from 'primeng/tooltip';
import { RoleSelectionComponent } from './components/role-selection/role-selection.component';

@NgModule({
  declarations: [SidebarComponent, HeaderComponent, DashboardPageComponent, RoleSelectionComponent],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule,
    FormsModule,
    BadgeModule,
    TooltipModule,
  ],
  exports: [DashboardPageComponent, RoleSelectionComponent],
})
export class CoreModule {}
