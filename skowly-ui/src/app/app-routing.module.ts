import { NgModule } from '@angular/core';
import { RouterModule, Routes, mapToCanActivate } from '@angular/router';
import { PublicPageComponent } from './public-page/public-page.component';
import { PrivatePageComponent } from './private-page/private-page.component';
import { AuthGuard } from './core/auth/auth.guard';
import { UnauthorizedPageComponent } from './unauthorized-page/unauthorized-page.component';

const routes: Routes = [
  { path: '', component: PublicPageComponent, data: { allowAnonymous: true } },
  { path: 'unauthorized', component: UnauthorizedPageComponent, data: { allowAnonymous: true } },
  { path: 'private-page', component: PrivatePageComponent, canActivate: mapToCanActivate([AuthGuard]) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
