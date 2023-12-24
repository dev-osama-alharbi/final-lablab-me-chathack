import {Component, ElementRef, ViewChild} from '@angular/core';
import {ApiService} from "../../../services/api.service";
import {NewMsgDTO} from "../../../dto/new.msg.dto";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-msg-write',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './msg-write.component.html',
  styleUrl: './msg-write.component.css'
})
export class MsgWriteComponent {
  constructor(private apiService:ApiService) {
  }
  inputMsg: string = '';

  sendMsg() {
    const newMsgDTO = new NewMsgDTO();
    newMsgDTO.msg = this.inputMsg;

    this.apiService.addMsg(1,newMsgDTO);
    this.inputMsg = "";
  }

  onEnter() {
    this.sendMsg();
  }
}
