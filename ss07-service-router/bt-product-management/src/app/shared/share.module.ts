import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NavBarComponent } from './nav-bar/nav-bar.component';
import {ShareRoutingModule} from "./share-routing.module";


@NgModule({
  declarations: [NavBarComponent],
  exports: [
    NavBarComponent
  ],
  imports: [
    CommonModule,
    ShareRoutingModule
  ]
})
export class SharedModule { }
