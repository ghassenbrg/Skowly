import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestInterceptor } from './core/interceptors/request.interceptor';
import { PublicPageComponent } from './public-page/public-page.component';
import { PrivatePageComponent } from './private-page/private-page.component';
import { UnauthorizedPageComponent } from './unauthorized-page/unauthorized-page.component';
import { PlateformManagementModule } from './features/plateform-management/plateform-management.module';

@NgModule({
  declarations: [
    AppComponent,
    PublicPageComponent,
    PrivatePageComponent,
    UnauthorizedPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    PlateformManagementModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true },
    // other providers
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
