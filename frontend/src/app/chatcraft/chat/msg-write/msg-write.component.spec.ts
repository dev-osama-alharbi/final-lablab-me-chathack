import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MsgWriteComponent } from './msg-write.component';

describe('MsgWriteComponent', () => {
  let component: MsgWriteComponent;
  let fixture: ComponentFixture<MsgWriteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MsgWriteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MsgWriteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
