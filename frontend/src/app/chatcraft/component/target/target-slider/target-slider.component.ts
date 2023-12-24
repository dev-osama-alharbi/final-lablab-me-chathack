import {Component, Input, OnInit} from '@angular/core';
import {TargetSliderTableItemComponent} from "../target-slider-table-item/target-slider-table-item.component";
import {TargetSliderTableComponent} from "../target-slider-table/target-slider-table.component";
import {ComponentM} from "../../../../dto/tag.dto";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-target-slider',
  standalone: true,
  imports: [
    TargetSliderTableItemComponent,
    TargetSliderTableComponent,
    NgIf
  ],
  templateUrl: './target-slider.component.html',
  styleUrl: './target-slider.component.css'
})
export class TargetSliderComponent implements OnInit{
  target = '';
  ngOnInit(): void {
      this.target = "#"+this.componentM.id;
  }
  @Input() componentM!: ComponentM;

}
