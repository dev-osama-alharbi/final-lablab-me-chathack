import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatcraftComponent } from './chatcraft.component';

describe('ChatcraftComponent', () => {
  let component: ChatcraftComponent;
  let fixture: ComponentFixture<ChatcraftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChatcraftComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChatcraftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
