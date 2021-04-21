import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeaturePackedRoutingModule } from './feature-packed-routing.module';
import { SampleOneComponent } from './sample-one/sample-one.component';
import { SampleTwoComponent } from './sample-two/sample-two.component';


@NgModule({
  declarations: [
    SampleOneComponent,
    SampleTwoComponent
  ],
  imports: [
    CommonModule,
    FeaturePackedRoutingModule
  ]
})
export class FeaturePackedModule {
  constructor() {
    console.log("loaded feature module");
  }
 }
