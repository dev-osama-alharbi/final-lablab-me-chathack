import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyProjectsInviteComponent } from './my-projects-invite.component';

describe('MyProjectsInviteComponent', () => {
  let component: MyProjectsInviteComponent;
  let fixture: ComponentFixture<MyProjectsInviteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyProjectsInviteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MyProjectsInviteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
