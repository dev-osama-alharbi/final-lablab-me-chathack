import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {AddNewTagDTO} from "../../../dto/addNewTagDTO";
import {ModelsService} from "../../../services/models.service";
import {ApiService} from "../../../services/api.service";
import {ActivatedRoute} from "@angular/router";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-msg-tag-popup-form',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    FormsModule
  ],
  templateUrl: './msg-tag-popup-form.component.html',
  styleUrl: './msg-tag-popup-form.component.css'
})
export class MsgTagPopupFormComponent implements OnInit{

  constructor(protected models:ModelsService,
              private apiService:ApiService,
              private route: ActivatedRoute)
  {

  }

  ngOnInit(): void {
    this.projectId = Number(this.route.snapshot.paramMap.get("id"));
  }


  isStatusNewChecked: boolean = false;
  isTypeDatabaseChecked: boolean = true;
  projectId: number = 0;

  @ViewChild('dialog') private closeModal: ElementRef | undefined;
  @Input() msgId: number | undefined;
  // @Input() msgIdIn = new EventEmitter<number>();
  title: string = '';
  @ViewChild('titleInput') titleInput: ElementRef | undefined;
  selectedOpt = 0;
  onClickSave() {
    if (this.closeModal == null) {
      return;
    }
    this.closeModal.nativeElement.click();

    const tag = new AddNewTagDTO();
    tag.msgId = this.msgId;
    tag.statusNew = this.isStatusNewChecked;
    tag.typeDb = this.isTypeDatabaseChecked;
    let title = '';
    let option = 0;
    if(this.titleInput){
      title = this.titleInput.nativeElement.value;
      this.titleInput.nativeElement.value = '';
    }

    if(this.isTypeDatabaseChecked){
      if(this.isStatusNewChecked){
        tag.title = title;
      }else{
        tag.parentComponentId = this.selectedOpt;
      }
    }else{
      tag.title = "Description";
    }
    // console.log("this.selected " +this.selectedOpt);
    this.apiService.addTag(this.projectId,tag);
  }

  checkStatusNewValue(check: boolean) {
    this.isStatusNewChecked = check;
  }

  checkTypeNewValue(check: boolean) {
    this.isTypeDatabaseChecked = check;
  }

  newTitle(value: string) {
    this.title = value;
  }
}
