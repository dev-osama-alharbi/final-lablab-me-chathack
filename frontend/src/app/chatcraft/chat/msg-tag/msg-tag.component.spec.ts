import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsgTagComponent } from './msg-tag.component';

describe('MsgSentTagComponent', () => {
  let component: MsgTagComponent;
  let fixture: ComponentFixture<MsgTagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MsgTagComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MsgTagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
