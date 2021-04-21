import { Component } from '@angular/core';
import { ApiClientService } from './services/api-client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  //A component is a directive, all directives have an injector.
  //    therefore, we can create instances of services for each
  //    components and directives by specifying them in the 
  //    component/directives providers array in the decorator.
  providers: []
})
export class AppComponent {

  constructor(private api: ApiClientService){}

  callApi(){
    this.api.getSomething('https://pokeapi.co/api/v2/pokemon/6');
    console.log("Separation of calls =========================");
    this.api.printApi();
  }
  title = 'toh';
}
