import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoCreateComponent} from './todo/todo-create/todo-create.component';
import {TodoEditComponent} from './todo/todo-edit/todo-edit.component';
import {TodoDeleteComponent} from './todo/todo-delete/todo-delete.component';


const routes: Routes = [
  {path: '', component: TodoCreateComponent},
  {path: 'todo-edit', component: TodoEditComponent},
  {path: 'todo-delete', component: TodoDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
