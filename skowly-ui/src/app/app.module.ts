import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule, APP_INITIALIZER  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestInterceptor } from './core/interceptors/request.interceptor';
import { PlateformManagementModule } from './features/plateform-management/plateform-management.module';
import { PrivatePageComponent } from './private-page/private-page.component';
import { PublicPageComponent } from './public-page/public-page.component';
import { UnauthorizedPageComponent } from './unauthorized-page/unauthorized-page.component';
import { CoreModule } from './core/core.module';
import { AuthenticationService } from './core/auth/auth.service';

export function initializeApp(authService: AuthenticationService) {
  return (): Promise<any> => {
    return authService.initializeApp();
  };
}

@NgModule({
  declarations: [
    AppComponent,
    PublicPageComponent,
    PrivatePageComponent,
    UnauthorizedPageComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    CoreModule,
    PlateformManagementModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true },
    {
      provide: APP_INITIALIZER,
      useFactory: initializeApp,
      deps: [AuthenticationService],
      multi: true,
    },
    // other providers
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
