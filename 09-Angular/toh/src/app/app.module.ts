import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServiceExampleComponent } from './components/service-example/service-example.component';
import { StructureArrayExampleComponent } from './components/structure-array-example/structure-array-example.component';
import { ColoredDirective } from './directives/enlarge.directive';
import { ApiSomething } from './services/api/ApiSomething';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


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
    HttpClientModule,
    BrowserAnimationsModule
  ],
  // The providers array registers a class with the associated injector
  providers: [ApiSomething],
  bootstrap: [AppComponent]
})
export class AppModule { }
