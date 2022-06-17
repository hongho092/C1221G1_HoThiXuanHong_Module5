import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from "./shared/share.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}



// declarations: [
//   AppComponent,
//   ProductListComponent,
//   ProductCreateComponent,
//   ProductEditComponent,
//   ProductDeleteComponent,
//   CategoryListComponent,
//   CategoryEditComponent,
//   CategoryCreateComponent,
//   CategoryDeleteComponent,
//   NavBarComponent
// ],
//   imports: [
//   BrowserModule,
//   AppRoutingModule,
//   ReactiveFormsModule,
//   HttpClientModule
// ],
//   providers: [],
//   bootstrap: [AppComponent]
// })
