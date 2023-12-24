import {Component, Input, OnInit} from '@angular/core';
import {AddNewTagDTO} from "../../../dto/addNewTagDTO";
import {Tag} from "../../../dto/tag.dto";
import {ModelsService} from "../../../services/models.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-msg-tag',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './msg-tag.component.html',
  styleUrl: './msg-tag.component.css'
})
export class MsgTagComponent implements OnInit{
  @Input() tag!: Tag;

  title = "";
  isDb = false;

  constructor(protected models:ModelsService)
  {

  }

  ngOnInit(): void {
    if(this.tag){
      if(this.tag.isComponent){
        if(this.tag.component){
          this.title = this.tag.component.title;
          this.isDb = this.tag.component.componentType.endsWith("DB");
          return;
        }
      }else{
        if(this.tag.item){
          const comp = this.models.listComponent.get(this.tag.item.componentId);
          this.title = this.models.getDbTitleByComponentId(this.tag.item.componentId);
          if(comp){
            this.isDb = comp.componentType.endsWith("DB");
          }
          return;
        }
      }
    }
    this.title = "";
  }
}
