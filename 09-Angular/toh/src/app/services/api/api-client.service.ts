import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiSomething } from './ApiSomething';

// injectable means that the class that is decorated can have something 
//    injected inside of it.
@Injectable({
  // provides a lazy loading for your services. This is a backwards 
  //    declaration of a service
  providedIn: 'root'
})
export class ApiClientService {
  constructor(
     private something: ApiSomething,  private httpClient: HttpClient
  ) {}

    getSomething(url:string):any{
      this.httpClient.get(url).toPromise().then(console.log);
      const subscriber = this.httpClient.get(url).subscribe(console.log)
      subscriber.unsubscribe();
    }
    
  printApi(){
    console.log("printing in the api service");
    this.something.print();
  }
}
