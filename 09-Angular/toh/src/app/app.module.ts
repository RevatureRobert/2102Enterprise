import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApiSomething } from './services/ApiSomething';
import {HttpClientModule} from '@angular/common/http'
import { ApiClientService } from './services/api-client.service';

@NgModule({
  declarations: [
    AppComponent
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
