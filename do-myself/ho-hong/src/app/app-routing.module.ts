import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './hop-dong/list/list.component';
import {CreateComponent} from './hop-dong/create/create.component';
import {EditComponent} from './hop-dong/edit/edit.component';


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
