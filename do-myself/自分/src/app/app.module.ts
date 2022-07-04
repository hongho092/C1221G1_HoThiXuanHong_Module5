import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { NgForComponent } from './ng-for/ng-for.component';
import { NgSwitchComponent } from './ng-switch/ng-switch.component';
import { NgIfComponent } from './ng-if/ng-if.component';
import { NgClassComponent } from './ng-class/ng-class.component';
import { NgStyleComponent } from './ng-style/ng-style.component';
import { HighLightDirective } from './high-light.directive';
import { CustomDirectiveComponent } from './custom-directive/custom-directive.component';
import { AppNotDirective } from './app-not.directive';
import { PipesComponent } from './pipes/pipes.component';
import {environment} from '../environments/environment';
import {AngularFireModule} from '@angular/fire/compat';
import { UploadImgComponent } from './upload-img/upload-img.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    CustomerComponent,
    NgForComponent,
    NgSwitchComponent,
    NgIfComponent,
    NgClassComponent,
    NgStyleComponent,
    HighLightDirective,
    CustomDirectiveComponent,
    AppNotDirective,
    PipesComponent,
    UploadImgComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
