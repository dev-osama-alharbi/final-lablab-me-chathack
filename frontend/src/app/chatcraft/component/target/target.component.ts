import { Component } from '@angular/core';
import {TargetSliderComponent} from "./target-slider/target-slider.component";
import {ModelsService} from "../../../services/models.service";
import {ApiService} from "../../../services/api.service";
import {ActivatedRoute} from "@angular/router";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-target',
  standalone: true,
  imports: [
    TargetSliderComponent,
    NgForOf
  ],
  templateUrl: './target.component.html',
  styleUrl: './target.component.css'
})
export class TargetComponent {

  constructor(protected models:ModelsService)
  {

  }
}
