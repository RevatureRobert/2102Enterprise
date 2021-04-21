import { TestBed } from '@angular/core/testing';

import { RouteGuarderService } from './route-guarder.service';

describe('RouteGuarderService', () => {
  let service: RouteGuarderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteGuarderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
