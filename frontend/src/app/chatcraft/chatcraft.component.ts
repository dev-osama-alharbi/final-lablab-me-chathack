import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ChatComponent} from "./chat/chat.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {UsersComponent} from "./users/users.component";
import {ComponentComponent} from "./component/component.component";
import {ExportComponent} from "./export/export.component";
import {RouterLink, RouterOutlet} from "@angular/router";
// import {CommonModule, NgIf} from "@angular/common";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {NgIf} from "@angular/common";
import {WsService} from "../services/ws.service";
import {ModelsService} from "../services/models.service";
import {ApiService} from "../services/api.service";
import {MsgTagPopupFormComponent} from "./chat/msg-tag-popup-form/msg-tag-popup-form.component";

@Component({
  selector: 'app-chatcraft',
  standalone: true,
    imports: [
        ChatComponent,
        DashboardComponent,
        UsersComponent,
        ComponentComponent,
        ExportComponent,
        RouterOutlet,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule,
        MatSidenavModule,
        NgIf,
        RouterLink,
        MsgTagPopupFormComponent,
    ],
  templateUrl: './chatcraft.component.html',
  styleUrl: './chatcraft.component.css',
})
export class ChatcraftComponent implements OnInit{
// export class ChatcraftComponent{
  isShowDashboard: boolean = false;
  isShowChat: boolean = false;
  isShowUsers: boolean = false;
  isShowComponent: boolean = false;
  isShowExport: boolean = false;

  navLinkEls = document.getElementsByClassName('nav__link');
  windowPathName = window.location.pathname;

  // @Output() listMsg: string[] = [];
  @Input() msgIdIn = new EventEmitter<number>();

  @Output() msgId: number | undefined;

  constructor(private ws: WsService,
              private models:ModelsService,
              private apiService:ApiService)
  {

  }

  ngOnInit(): void {
    this._initHotKeyNavbar();
    this._pageView();
    this.apiInit();
    this.wsInit();
  }

  apiInit(){
    this.apiService.getAllMsg(1,this.models);
    this.apiService.getAllTag(1,this.models);
    // this.models.addAllMsg(this.apiService.getAllMsg());
  }

  wsInit(){
    this.ws.connect(() => {
      this.ws.subLsn(1,this.models);
    });
  }


  _initHotKeyNavbar(){
    console.log('navLinkEls '+this.navLinkEls.length)
    for (let i = 0; i < this.navLinkEls.length; i++) {
      const el = this.navLinkEls[i] as HTMLElement;
      const navLinkPathname = new URL(el.getElementsByTagName("a").item(0)!.href).pathname;
      console.log(this.windowPathName+ " --- "+navLinkPathname)
      if(this.windowPathName === navLinkPathname){
        el.classList.add('active');
      }
    }
  }
  _pageView(){
    this._otherIsShowFalse();
    if(this.windowPathName.endsWith("dashboard")){
      this.isShowDashboard = true;
    }else if(this.windowPathName.endsWith("chat")){
      this.isShowChat = true;
    }else if(this.windowPathName.endsWith("users")){
      this.isShowUsers = true;
    }else if(this.windowPathName.endsWith("component")){
      this.isShowComponent = true;
    }else if(this.windowPathName.endsWith("export")){
      this.isShowExport = true;
    }
  }

  _otherIsShowFalse(){
    this.isShowDashboard = false;
    this.isShowChat = false;
    this.isShowUsers = false;
    this.isShowComponent = false;
    this.isShowExport = false;
  }

  popupClick($event: number) {
    // this.msgIdIn.emit($event);
    this.msgId = $event;
  }
}
