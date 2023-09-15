import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { DashboardPageComponent } from './components/dashboard-page/dashboard-page.component';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [SidebarComponent, HeaderComponent, DashboardPageComponent],
  imports: [CommonModule, RouterModule, BrowserModule, FormsModule],
  exports: [DashboardPageComponent],
})
export class CoreModule {}
