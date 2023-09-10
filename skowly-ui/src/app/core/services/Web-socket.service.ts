import { Injectable } from '@angular/core';
import { keycloak } from 'src/main';

declare var SockJS: any;
declare var Stomp: any;

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  public stompClient: any;
  public msg: any[] = [];

  constructor() {
  }

  public connect(url: string, topic:string): void {
    console.log(url);

    const ws = new SockJS(url);
    this.stompClient = Stomp.over(ws);

    this.stompClient.connect({}, (frame: string) => {
      console.log('Connected: ' + frame);
      this.subscribeToMessages(topic);
    }, (error: any) => {
      console.error('STOMP error', error);
    });
  }

  private subscribeToMessages(topic: string): void {
    this.stompClient.subscribe(topic, (message: { body: any; }) => {
      if (message.body) {
        this.msg.push(JSON.parse(message.body));
      }
    });
  }

  public sendMessage(destination:string, message: any): void {
    this.stompClient.send(destination, {}, JSON.stringify(message));
  }

  // Optional: Method to manually disconnect the WebSocket
  public disconnect(): void {
    if (this.stompClient) {
      this.stompClient.disconnect(() => {
        console.log('Disconnected');
      });
    }
  }
}
