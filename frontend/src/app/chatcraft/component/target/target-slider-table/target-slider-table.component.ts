import {Component, Input} from '@angular/core';
import {TargetSliderTableItemComponent} from "../target-slider-table-item/target-slider-table-item.component";
import {ComponentM} from "../../../../dto/tag.dto";
import {ModelsService} from "../../../../services/models.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-target-slider-table',
  standalone: true,
  imports: [
    TargetSliderTableItemComponent,
    NgForOf,
    NgIf
  ],
  templateUrl: './target-slider-table.component.html',
  styleUrl: './target-slider-table.component.css'
})
export class TargetSliderTableComponent {
  @Input() componentM!: ComponentM;
  constructor(protected models:ModelsService)
  {

  }
}
