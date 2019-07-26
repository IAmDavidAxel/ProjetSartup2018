import { TestBed } from '@angular/core/testing';

import { BarbarProfileService } from './barbar-profile.service';

describe('BarbarProfileService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BarbarProfileService = TestBed.get(BarbarProfileService);
    expect(service).toBeTruthy();
  });
});
