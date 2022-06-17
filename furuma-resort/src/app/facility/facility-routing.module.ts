import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListFacilityComponent} from './list-facility/list-facility.component';
import {CreateFacilityComponent} from './create-facility/create-facility.component';
import {EditFacilityComponent} from './edit-facility/edit-facility.component';


const routes: Routes = [
  {path: 'list', component: ListFacilityComponent},
  {path: 'create', component: CreateFacilityComponent},
  {path: 'edit/:id', component: EditFacilityComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
