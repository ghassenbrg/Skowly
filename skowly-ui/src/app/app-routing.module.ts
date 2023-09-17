// In your AppRoutingModule
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthGuard } from './core/auth/auth.guard';
import { DashboardPageComponent } from './core/components/dashboard-page/dashboard-page.component';
import { RoleSelectionComponent } from './core/components/role-selection/role-selection.component';
import { PrivatePageComponent } from './private-page/private-page.component';
import { PublicPageComponent } from './public-page/public-page.component';

const routes: Routes = [
  {
    path: '',
    component: AppComponent,
    data: { allowAnonymous: true },
    children: [
      {
        path: '',
        component: PublicPageComponent,
        data: { allowAnonymous: true },
      },
      {
        path: 'dashboard',
        component: DashboardPageComponent,
        canActivate: [AuthGuard],
        children: [
          {
            path: 'private-page',
            component: PrivatePageComponent,
            canActivate: [AuthGuard],
          },
          {
            path: 'platform-management',
            canActivate: [AuthGuard],
            loadChildren: () =>
              import(
                './features/plateform-management/plateform-management.module'
              ).then((m) => m.PlateformManagementModule),
          },
        ],
      },
      {
        path: 'role-selection',
        component: RoleSelectionComponent,
        canActivate: [AuthGuard],
        data: { noRoleNeeded: true },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
