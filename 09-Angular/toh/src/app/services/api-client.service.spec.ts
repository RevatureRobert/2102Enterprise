import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ApiClientService } from './api-client.service';
import { ApiSomething } from './ApiSomething';

describe('ApiClientService', () => {
  let service: ApiClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports:[HttpClientModule], providers:[ApiSomething]});
    service = TestBed.inject(ApiClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
    // expect(service.printApi()).toBeUndefined();
  });

  it('should call pokemon api', () => {
    expect(
      service.getSomething('https://pokeapi.co/api/v2/pokemon/5')
    ).toBeUndefined();
  });
});
