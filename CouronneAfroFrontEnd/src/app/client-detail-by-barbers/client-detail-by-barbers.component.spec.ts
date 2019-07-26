import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientDetailByBarbersComponent } from './client-detail-by-barbers.component';

describe('ClientDetailByBarbersComponent', () => {
  let component: ClientDetailByBarbersComponent;
  let fixture: ComponentFixture<ClientDetailByBarbersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientDetailByBarbersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientDetailByBarbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
