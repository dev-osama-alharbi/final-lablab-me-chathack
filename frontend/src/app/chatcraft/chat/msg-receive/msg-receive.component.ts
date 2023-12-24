import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MsgDTO} from "../../../dto/msg.dto";
import {MsgTagComponent} from "../msg-tag/msg-tag.component";
import {NgForOf} from "@angular/common";
import {ModelsService} from "../../../services/models.service";

@Component({
  selector: 'app-msg-receive',
  standalone: true,
    imports: [
        MsgTagComponent,
        NgForOf
    ],
  templateUrl: './msg-receive.component.html',
  styleUrl: './msg-receive.component.css'
})
export class MsgReceiveComponent {
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
