import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { keycloak } from 'src/main';


@Injectable({ providedIn: 'root' })
export class AuthenticationService {

    keycloak = keycloak;

    constructor(private router: Router) {}

    logout(targetPath?: string) {
        const targetUrl = decodeURIComponent(window.location.origin + (targetPath ? targetPath : this.router.url));
        keycloak.logout({
          redirectUri: targetUrl,
        });
      }
    
      login(targetPath?: string) {
        const targetUrl = decodeURIComponent(window.location.origin + (targetPath ? targetPath : this.router.url));
        keycloak.login({
          redirectUri: targetUrl,
        });
      }

}