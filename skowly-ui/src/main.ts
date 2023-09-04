import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { enableProdMode } from '@angular/core';
import { environment } from './environments/environment';
import Keycloak from 'keycloak-js';

if (environment.production) {
  enableProdMode();
}

export const keycloak = new Keycloak({
  url: 'http://localhost:4200/auth',
  realm: 'skowly',
  clientId: 'external-client',
});

keycloak.init({ onLoad: 'login-required' }).then((authenticated) => {
  if (authenticated) {
    platformBrowserDynamic()
      .bootstrapModule(AppModule)
      .catch((err) => console.error(err));
  } else {
    // Handle unauthorized access, show a message, etc.
  }
});