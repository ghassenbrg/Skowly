import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { WebSocketService } from '../core/services/Web-socket.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-private-page',
  templateUrl: './private-page.component.html',
  styleUrls: ['./private-page.component.scss'],
})
export class PrivatePageComponent {
  private subscription: Subscription = new Subscription();
  public message: string = '';
  randomUserName: string = '';
  constructor(public webSocketService: WebSocketService) {}

  ngOnInit(): void {
    this.randomUserName = 'Skowly_' + this.getRandomInt(1000);
    // Connect to WebSocket server
    this.webSocketService.connect(
      environment.websocket_url,
      '/topic/messages'
    );
  }

  send(): void {
    // Send a message to the '/app/send' destination
    let payload: any = {
      username: this.randomUserName,
      text: this.message
    };

    this.webSocketService.sendMessage('/app/send', payload);
    this.message = '';
  }

  private getRandomInt(max: number): number {
    return Math.floor(Math.random() * Math.floor(max));
  }

  ngOnDestroy(): void {
    this.webSocketService.disconnect();
  }
}
