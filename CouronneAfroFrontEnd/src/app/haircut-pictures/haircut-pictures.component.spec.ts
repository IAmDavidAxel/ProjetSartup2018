import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HaircutPicturesComponent } from './haircut-pictures.component';

describe('HaircutPicturesComponent', () => {
  let component: HaircutPicturesComponent;
  let fixture: ComponentFixture<HaircutPicturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HaircutPicturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaircutPicturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
