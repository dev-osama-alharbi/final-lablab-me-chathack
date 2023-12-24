import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ResultButtonsComponent} from "./result-buttons/result-buttons.component";
import {ResultCodeComponent} from "./result-code/result-code.component";

@Component({
  selector: 'app-result',
  standalone: true,
  imports: [
    ResultButtonsComponent,
    ResultCodeComponent
  ],
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent {

  @Input() resultIn = new EventEmitter<string>();

  @Output() result:string = "";
  // result: string = "";
  resultEmit(sss: string) {
    this.result = sss;
  }

  resultData() {
    return this.result;
  }
}
