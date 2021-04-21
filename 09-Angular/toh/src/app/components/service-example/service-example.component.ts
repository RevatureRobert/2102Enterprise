import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../../services/api/api-client.service';

@Component({
  selector: 'app-service-example',
  templateUrl: './service-example.component.html',
  styleUrls: ['./service-example.component.css'],
  //A component is a directive, all directives have an injector.
  //    therefore, we can create instances of services for each
  //    components and directives by specifying them in the 
  //    component/directives providers array in the decorator.
  providers: []
})
export class ServiceExampleComponent implements OnInit {

  constructor(private api: ApiClientService){}
  ngOnInit(): void {
    
  }

  callApi(){
    this.api.getSomething('https://pokeapi.co/api/v2/pokemon/6');
    console.log("Separation of calls =========================");
    this.api.printApi();
  }
}
