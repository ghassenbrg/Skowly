// In your AppRoutingModule
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthGuard } from './core/auth/auth.guard';
import { PrivatePageComponent } from './private-page/private-page.component';
import { PublicPageComponent } from './public-page/public-page.component';
import { UnauthorizedPageComponent } from './unauthorized-page/unauthorized-page.component';
import { DashboardPageComponent } from './core/components/dashboard-page/dashboard-page.component';

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
            path: 'unauthorized',
            component: UnauthorizedPageComponent,
            data: { allowAnonymous: true },
          },
          {
            path: 'private-page',
            component: PrivatePageComponent,
          },
          {
            path: 'platform-management',
            loadChildren: () =>
              import(
                './features/plateform-management/plateform-management.module'
              ).then((m) => m.PlateformManagementModule),
          },
        ],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
