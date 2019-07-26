import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RendezVousTableComponent } from './rendez-vous-table.component';

describe('RendezVousTableComponent', () => {
  let component: RendezVousTableComponent;
  let fixture: ComponentFixture<RendezVousTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RendezVousTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RendezVousTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
