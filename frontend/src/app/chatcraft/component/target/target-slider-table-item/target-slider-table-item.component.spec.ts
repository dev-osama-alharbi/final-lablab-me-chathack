import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TargetSliderTableItemComponent } from './target-slider-table-item.component';

describe('TargetSliderTableItemComponent', () => {
  let component: TargetSliderTableItemComponent;
  let fixture: ComponentFixture<TargetSliderTableItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TargetSliderTableItemComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TargetSliderTableItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
