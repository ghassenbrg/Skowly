import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { keycloak } from 'src/main';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'skowly-ui';

  constructor(private http: HttpClient) {

  }
  
  logout() {
    keycloak.logout({
      redirectUri: window.location.origin,
    });
  }

  callHello(){
    this.http.get('http://localhost:4200/api/core/hello').subscribe(r => console.log(r))
  } 
  
}
