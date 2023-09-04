import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { keycloak } from 'src/main';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../core/auth/auth.service';

@Component({
  selector: 'app-unauthorized-page',
  templateUrl: './unauthorized-page.component.html',
  styleUrls: ['./unauthorized-page.component.scss']
})
export class UnauthorizedPageComponent {

  keycloak = keycloak;

  constructor(private activatedRoute: ActivatedRoute, private auth: AuthenticationService) {}

  logout() {
    this.auth.logout();
  }

  login() {
    this.activatedRoute.queryParams.subscribe(params => {
      const targetUrl = params['targetUrl'];
      if (targetUrl) {
        this.auth.login(targetUrl);
      } else {
        this.auth.login('/');
      }
    });
  }
  

}
