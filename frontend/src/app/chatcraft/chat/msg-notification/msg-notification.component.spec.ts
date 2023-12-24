import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsgNotificationComponent } from './msg-notification.component';

describe('MsgNotificationComponent', () => {
  let component: MsgNotificationComponent;
  let fixture: ComponentFixture<MsgNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MsgNotificationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MsgNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
