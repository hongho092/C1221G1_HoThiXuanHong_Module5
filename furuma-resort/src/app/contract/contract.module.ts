import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import {ListContractComponent} from './list-contract/list-contract.component';
import {CreateContractComponent} from './create-contract/create-contract.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    ListContractComponent,
    CreateContractComponent
  ],
    imports: [
        CommonModule,
        ContractRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        NgxPaginationModule
    ]
})
export class ContractModule { }
