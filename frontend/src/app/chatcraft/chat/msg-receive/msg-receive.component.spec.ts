import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsgReceiveComponent } from './msg-receive.component';

describe('MsgReceiveComponent', () => {
  let component: MsgReceiveComponent;
  let fixture: ComponentFixture<MsgReceiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MsgReceiveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MsgReceiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
