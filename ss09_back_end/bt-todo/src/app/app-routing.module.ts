import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoCreateComponent} from './todo/todo-create/todo-create.component';
import {TodoEditComponent} from './todo/todo-edit/todo-edit.component';
import {TodoDeleteComponent} from './todo/todo-delete/todo-delete.component';
import {TodoListComponent} from './todo/todo-list/todo-list.component';


const routes: Routes = [
  {path: '', component: TodoListComponent},
  {path: 'todo-create', component: TodoCreateComponent},
  {path: 'todo-edit', component: TodoEditComponent},
  {path: 'todo-delete', component: TodoDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
