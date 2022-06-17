import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {EditFacilityComponent} from './facility/edit-facility/edit-facility.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {CreateContractComponent} from './contract/create-contract/create-contract.component';
import {CreateFacilityComponent} from './facility/create-facility/create-facility.component';
import {DetailCustomerComponent} from './customer/detail-customer/detail-customer.component';


const routes: Routes = [
  // {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: HomeComponent},
  // {path: 'list-facility', component: ListFacilityComponent},
  // {path: 'create-facility', component: CreateFacilityComponent},
  // {path: 'edit-facility/:id', component: EditFacilityComponent},
  // {path: 'list-customer', component: ListCustomerComponent},
  // {path: 'create-customer', component: CreateCustomerComponent},
  // {path: 'detail-customer/:id', component: DetailCustomerComponent},
  // {path: 'edit-customer/:id', component: EditCustomerComponent},
  // {path: 'list', component: ListContractComponent},
  // {path: 'create', component: CreateContractComponent},
  {
    path: 'customer',
    loadChildren: () => import('./customer/customer.module').then(module => module.CustomerModule)
  },
  {
    path: 'facility',
    loadChildren: () => import('./facility/facility.module').then(module => module.FacilityModule)
  },
  {
    path: 'contract',
    loadChildren: () => import('./contract/contract.module').then(module => module.ContractModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  bootstrap: [ListCustomerComponent]
})
export class AppRoutingModule { }
