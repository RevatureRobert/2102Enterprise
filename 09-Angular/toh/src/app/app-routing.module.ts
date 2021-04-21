import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ServiceExampleComponent } from './components/service-example/service-example.component';
import { StructureArrayExampleComponent } from './components/structure-array-example/structure-array-example.component';
import { FeaturePackedModule } from './feature-packed/feature-packed.module';
import { RouteGuarderService } from './services/routeGuarder/route-guarder.service';

const routes: Routes = [
  // {path: '', component: AppComponent},
  { path: 'service', component: ServiceExampleComponent },
  {
    path: 'structure',
    component: StructureArrayExampleComponent,
    canActivate: [RouteGuarderService],
  },

  // {
  //   path: 'admin',
  //   loadChildren: () => RouterModule.forChild([]),
  //   canActivate: [RouteGuarderService],
  // },
  // {path: 'structure/:id', component: StructureArrayExampleComponent}
  {
    path: 'feature',
    loadChildren: () =>
      import('./feature-packed/feature-packed.module').then(
        (mod) => mod.FeaturePackedModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
