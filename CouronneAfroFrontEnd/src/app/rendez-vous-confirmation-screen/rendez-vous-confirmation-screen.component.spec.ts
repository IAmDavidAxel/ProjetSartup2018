import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RendezVousConfirmationScreenComponent } from './rendez-vous-confirmation-screen.component';

describe('RendezVousConfirmationScreenComponent', () => {
  let component: RendezVousConfirmationScreenComponent;
  let fixture: ComponentFixture<RendezVousConfirmationScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RendezVousConfirmationScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RendezVousConfirmationScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
