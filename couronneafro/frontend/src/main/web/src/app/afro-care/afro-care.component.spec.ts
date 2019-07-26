import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfroCareComponent } from './afro-care.component';

describe('AfroCareComponent', () => {
  let component: AfroCareComponent;
  let fixture: ComponentFixture<AfroCareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfroCareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfroCareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
