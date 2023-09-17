import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard {

  constructor(private readonly router: Router, private readonly auth: AuthenticationService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const targetUrl = decodeURIComponent(state.url);

    if (this.isUserAuthorized(route)) {
      return true;
    }
    
    if (this.userNeedsToSelectRole()) {
      return this.redirectToSelectRolePage(targetUrl);
    }

    return this.promptForLogin(targetUrl);
  }

  private isUserAuthorized(route: ActivatedRouteSnapshot): boolean {
    return (Boolean) (this.auth.isAuthenticated() && (this.auth.getSelectedRole() || this.isRoleNotRequired(route))) 
      || this.isAnonymousAllowed(route);
  }

  private isRoleNotRequired(route: ActivatedRouteSnapshot): boolean {
    return route.data['noRoleNeeded'];
  }

  private isAnonymousAllowed(route: ActivatedRouteSnapshot): boolean {
    return route.data['allowAnonymous'];
  }

  private userNeedsToSelectRole(): boolean {
    return this.auth.isAuthenticated() && !this.auth.getSelectedRole();
  }

  private redirectToSelectRolePage(targetUrl: string): UrlTree {
    return this.router.parseUrl(`/role-selection?targetUrl=${targetUrl}`);
  }

  private promptForLogin(targetUrl: string): boolean {
    this.auth.login(targetUrl);
    return false;
  }
}
