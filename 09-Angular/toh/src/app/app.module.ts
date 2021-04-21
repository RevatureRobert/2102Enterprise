import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApiSomething } from './services/ApiSomething';
import {HttpClientModule} from '@angular/common/http'
import { ApiClientService } from './services/api-client.service';
import { ServiceExampleComponent } from './components/service-example/service-example.component';
import { ColoredDirective } from './directives/enlarge.directive';
import { StructureArrayExampleComponent } from './components/structure-array-example/structure-array-example.component';

@NgModule({
  declarations: [
    AppComponent,
    ServiceExampleComponent,
    ColoredDirective,
    StructureArrayExampleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  // The providers array registers a class with the associated injector
  providers: [ApiSomething, ApiClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
