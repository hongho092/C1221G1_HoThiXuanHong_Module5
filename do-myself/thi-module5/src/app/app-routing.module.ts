import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './phuong-tien/list/list.component';
import {EditComponent} from './phuong-tien/edit/edit.component';
import {CreateComponent} from './phuong-tien/create/create.component';


const routes: Routes = [
  { path: '', component: ListComponent},
  { path: 'create', component: CreateComponent},
  { path: 'edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
