import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FacilityRoutingModule} from './facility-routing.module';
import {ListFacilityComponent} from './list-facility/list-facility.component';
import {CreateFacilityComponent} from './create-facility/create-facility.component';
import {EditFacilityComponent} from './edit-facility/edit-facility.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    ListFacilityComponent,
    CreateFacilityComponent,
    EditFacilityComponent,
  ],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ]
})
export class FacilityModule { }
