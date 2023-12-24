import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsgTagPopupFormComponent } from './msg-tag-popup-form.component';

describe('MsgTagPopupFormComponent', () => {
  let component: MsgTagPopupFormComponent;
  let fixture: ComponentFixture<MsgTagPopupFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MsgTagPopupFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MsgTagPopupFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
