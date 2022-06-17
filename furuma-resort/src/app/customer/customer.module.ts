import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {DetailCustomerComponent} from './detail-customer/detail-customer.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';



@NgModule({
  declarations: [
    ListCustomerComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    DetailCustomerComponent
  ],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        NgxPaginationModule
    ]
})
export class CustomerModule { }
