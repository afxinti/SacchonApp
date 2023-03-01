import { TestBed } from '@angular/core/testing';

import { DciService } from './dci.service';

describe('DciService', () => {
  let service: DciService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DciService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
