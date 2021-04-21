import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SampleOneComponent } from './sample-one/sample-one.component';
import { SampleTwoComponent } from './sample-two/sample-two.component';

const routes: Routes = [
  {path:'one', component: SampleOneComponent},
  {path: 'two', component: SampleTwoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturePackedRoutingModule { }
