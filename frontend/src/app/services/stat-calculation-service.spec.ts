import { TestBed } from '@angular/core/testing';

import { StatCalculationService } from './stat-calculation-service';

describe('CharacterService', () => {
  let service: StatCalculationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatCalculationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
