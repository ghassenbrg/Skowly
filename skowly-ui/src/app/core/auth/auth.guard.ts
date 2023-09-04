import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { keycloak } from 'src/main';
import { AuthenticationService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(private router: Router, private auth: AuthenticationService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    if (keycloak.authenticated || route.data['allowAnonymous']) {
      return true;
    }

    const targetUrl = decodeURIComponent(state.url);
    
    /*this.router.navigate(['/unauthorized'], {
      queryParams: { targetUrl: targetUrl }
    });
    */
    this.auth.login(targetUrl);

    return false;
  }
}
