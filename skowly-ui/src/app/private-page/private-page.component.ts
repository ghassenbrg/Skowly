import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { keycloak } from 'src/main';
import { AuthenticationService } from '../core/auth/auth.service';

@Component({
  selector: 'app-private-page',
  templateUrl: './private-page.component.html',
  styleUrls: ['./private-page.component.scss']
})
export class PrivatePageComponent {

  title = 'skowly-ui';
  keycloak = keycloak;
  hello: string = '';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  logout() {
    this.auth.logout();
  }

  login() {
    this.auth.login();
  }

  callHello() {
    this.http.get('http://localhost:4200/api/core/hello', { responseType: 'text' })
      .subscribe(
        data => {
          this.hello = data;
          console.log(data);
        },
        error => {
          console.log(error);
        }
      );

  }

}
