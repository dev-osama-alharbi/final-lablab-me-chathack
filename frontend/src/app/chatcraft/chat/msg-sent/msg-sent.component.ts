import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MsgDTO} from "../../../dto/msg.dto";
import {NgForOf} from "@angular/common";
import {ModelsService} from "../../../services/models.service";
import {MsgTagComponent} from "../msg-tag/msg-tag.component";
import {MsgTagPopupFormComponent} from "../msg-tag-popup-form/msg-tag-popup-form.component";

@Component({
  selector: 'app-msg-sent',
  standalone: true,
  imports: [
    NgForOf,
    MsgTagComponent,
    MsgTagPopupFormComponent,
  ],
  templateUrl: './msg-sent.component.html',
  styleUrl: './msg-sent.component.css'
})
export class MsgSentComponent implements OnInit{
  @Input() msg!: MsgDTO;
  @Output() msgIdm = new EventEmitter<number>();

  constructor(protected models:ModelsService)
  {

  }

  popupClick(id: number) {
    this.msgIdm.emit(id);
  }

  ngOnInit(): void {
  }
  addTag() {
    // this.matDialog.open(MsgTagPopupFormComponent);
    // const tag = new TagDTO();
    // tag.id = this.msg.id;
    // tag.title = "adasdasd";
    // tag.msgId = this.msg.id;
    // if(this.models.listTag.has(this.msg.id)){
    //   this.models.listTag.get(this.msg.id)?.push(tag);
    // }else{
    //   this.models.listTag.set(this.msg.id,[tag]);
    // }
  }
}
