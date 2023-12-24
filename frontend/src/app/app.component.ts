import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MsgWriteComponent} from "./chatcraft/chat/msg-write/msg-write.component";
import {MsgSentComponent} from "./chatcraft/chat/msg-sent/msg-sent.component";
import {MsgReceiveComponent} from "./chatcraft/chat/msg-receive/msg-receive.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, MsgWriteComponent, MsgSentComponent, MsgReceiveComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'chatcraft-frontend';
}
