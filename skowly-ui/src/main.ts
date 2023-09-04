import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { enableProdMode } from '@angular/core';
import { environment } from './environments/environment';
import Keycloak from 'keycloak-js';

if (environment.production) {
  enableProdMode();
}

export const keycloak = new Keycloak({
  url: environment.keycloak_url,
  realm: environment.keycloak_realm,
  clientId: environment.keycloak_clientId
});

keycloak.init({ onLoad: 'check-sso' }).then((authenticated) => {
  if (authenticated) {
    // Initialize your application
  }
  platformBrowserDynamic()
    .bootstrapModule(AppModule)
    .catch((err) => console.error(err));
});
