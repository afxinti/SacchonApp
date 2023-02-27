import { TestBed } from '@angular/core/testing';

import { BglService } from './bgl.service';

describe('BglService', () => {
  let service: BglService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BglService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
