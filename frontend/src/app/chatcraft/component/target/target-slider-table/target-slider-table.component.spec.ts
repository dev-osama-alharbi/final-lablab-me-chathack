import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TargetSliderTableComponent } from './target-slider-table.component';

describe('TargetSliderTableComponent', () => {
  let component: TargetSliderTableComponent;
  let fixture: ComponentFixture<TargetSliderTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TargetSliderTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TargetSliderTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
