import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {DetailCustomerComponent} from './detail-customer/detail-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';


const routes: Routes = [
  {path: 'list', component: ListCustomerComponent},
  {path: 'create', component: CreateCustomerComponent},
  {path: 'detail/:id', component: DetailCustomerComponent},
  {path: 'edit/:id', component: EditCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
