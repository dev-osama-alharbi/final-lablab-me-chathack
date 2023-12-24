import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultButtonsComponent } from './result-buttons.component';

describe('ResultButtonsComponent', () => {
  let component: ResultButtonsComponent;
  let fixture: ComponentFixture<ResultButtonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultButtonsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ResultButtonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
