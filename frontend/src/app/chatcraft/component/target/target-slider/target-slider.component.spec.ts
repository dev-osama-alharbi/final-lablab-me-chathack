import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TargetSliderComponent } from './target-slider.component';

describe('TargetSliderComponent', () => {
  let component: TargetSliderComponent;
  let fixture: ComponentFixture<TargetSliderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TargetSliderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TargetSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
