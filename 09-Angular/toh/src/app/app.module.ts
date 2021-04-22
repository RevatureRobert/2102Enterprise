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
import { TohFormComponent } from './components/toh-form/toh-form.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    ServiceExampleComponent,
    ColoredDirective,
    StructureArrayExampleComponent,
    TohFormComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule
  ],
  // The providers array registers a class with the associated injector
  providers: [ApiSomething],
  bootstrap: [AppComponent]
})
export class AppModule { }
