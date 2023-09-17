import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationService } from './core/auth/auth.service';
import { CoreModule } from './core/core.module';
import { RequestInterceptor } from './core/interceptors/request.interceptor';
import { AppInitializer } from './core/services/app.initalizer';
import { PlateformManagementModule } from './features/plateform-management/plateform-management.module';
import { PrivatePageComponent } from './private-page/private-page.component';
import { PublicPageComponent } from './public-page/public-page.component';
import { SharedModule } from './shared/shared.module';
import { UnauthorizedPageComponent } from './unauthorized-page/unauthorized-page.component';

export function initializeApp(appInitializer: AppInitializer) {
  return (): Promise<any> => {
    return appInitializer.initializeApp();
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
    SharedModule,
    PlateformManagementModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true },
    {
      provide: APP_INITIALIZER,
      useFactory: initializeApp,
      deps: [AppInitializer],
      multi: true,
    },
    // other providers
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
