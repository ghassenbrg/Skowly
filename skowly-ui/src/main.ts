import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import Keycloak from 'keycloak-js';
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

export const keycloak = new Keycloak({
  url: environment.keycloak_url,
  realm: environment.keycloak_realm,
  clientId: environment.keycloak_clientId,
});

keycloak.init({ onLoad: 'check-sso' }).then(async (authenticated) => {
  if (authenticated) {
    await keycloak.loadUserInfo();
  }
  platformBrowserDynamic()
    .bootstrapModule(AppModule)
    .catch((err) => console.error(err));
});
