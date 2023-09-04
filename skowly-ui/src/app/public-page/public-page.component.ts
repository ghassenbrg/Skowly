import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { keycloak } from 'src/main';

@Component({
  selector: 'app-public-page',
  templateUrl: './public-page.component.html',
  styleUrls: ['./public-page.component.scss']
})
export class PublicPageComponent {

  title = 'skowly-ui';
  keycloak = keycloak;
  hello: string = '';

  constructor(private http: HttpClient) {}

  logout() {
    keycloak.logout({
      redirectUri: window.location.origin,
    });
  }

  login() {
    keycloak.login({
      redirectUri: window.location.origin,
    });
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
