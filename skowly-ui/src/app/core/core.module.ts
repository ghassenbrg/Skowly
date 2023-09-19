import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DashboardPageComponent } from './components/dashboard-page/dashboard-page.component';

import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { BadgeModule } from 'primeng/badge';
import { TooltipModule } from 'primeng/tooltip';
import { SharedModule } from '../shared/shared.module';
import { HeaderComponent } from './components/header/header.component';
import { RoleSelectionComponent } from './components/role-selection/role-selection.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { DialogModule } from 'primeng/dialog';

@NgModule({
  declarations: [
    SidebarComponent,
    HeaderComponent,
    DashboardPageComponent,
    RoleSelectionComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule,
    SharedModule,
    FormsModule,
    BadgeModule,
    TooltipModule,
    DialogModule,
  ],
  exports: [DashboardPageComponent, RoleSelectionComponent],
})
export class CoreModule {}
