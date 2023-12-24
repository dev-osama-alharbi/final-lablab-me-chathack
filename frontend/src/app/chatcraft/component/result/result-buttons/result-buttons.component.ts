import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ModelsService} from "../../../../services/models.service";
import {ApiService} from "../../../../services/api.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-result-buttons',
  standalone: true,
  imports: [],
  templateUrl: './result-buttons.component.html',
  styleUrl: './result-buttons.component.css'
})
export class ResultButtonsComponent implements OnInit{

  constructor(protected models:ModelsService,
              private apiService:ApiService,
              private route: ActivatedRoute)
  {

  }

  // @Output() result:string = "";

  ngOnInit(): void {
    this.projectId = Number(this.route.snapshot.paramMap.get("id"));
  }
  projectId: number = 0;
  @Output() result = new EventEmitter<string>();


  java() {
    // this.apiService.callAiJava(this.projectId,(answer) => {
    //   this.result.emit(answer);
    // });
  }

  cpp() {
    this.apiService.callAiCpp(this.projectId,(answer) => {
      this.result.emit(answer);
    });
  }

  json() {
    // this.apiService.callAiJson(this.projectId,(answer) => {
    //   this.result.emit(answer);
    // });
  }

  sql() {
    this.apiService.callAiSql(this.projectId,(answer) => {
      this.result.emit(answer);
    });
  }

  description() {
    this.apiService.callAiDes(this.projectId,(answer) => {
      this.result.emit(answer);
    });
    // this.result = this.apiService.callAiDes(this.projectId);
    // this.result = this.apiService.callAiDes(this.projectId);
  }
}
