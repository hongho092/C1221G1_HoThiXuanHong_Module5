import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './dictionary/list/list.component';
import {DetailComponent} from './dictionary/detail/detail.component';


const routes: Routes = [
  {path: '', component: ListComponent},
  {path: 'detail/:id', component: DetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
