import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { ListComponent } from './hop-dong/list/list.component';
import { CreateComponent } from './hop-dong/create/create.component';
import { EditComponent } from './hop-dong/edit/edit.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    CreateComponent,
    EditComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
