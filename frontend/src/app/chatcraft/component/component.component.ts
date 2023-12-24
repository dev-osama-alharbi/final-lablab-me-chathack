import { Component } from '@angular/core';
import {TargetComponent} from "./target/target.component";
import {ResultComponent} from "./result/result.component";

@Component({
  selector: 'app-component',
  standalone: true,
  imports: [
    TargetComponent,
    ResultComponent
  ],
  templateUrl: './component.component.html',
  styleUrl: './component.component.css'
})
export class ComponentComponent {

}
