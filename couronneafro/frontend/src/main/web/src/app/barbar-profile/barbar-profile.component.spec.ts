import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BarbarProfileComponent } from './barbar-profile.component';

describe('BarbarProfileComponent', () => {
  let component: BarbarProfileComponent;
  let fixture: ComponentFixture<BarbarProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BarbarProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BarbarProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
