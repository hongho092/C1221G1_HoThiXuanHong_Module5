import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductEditComponent} from "./product/product-edit/product-edit.component";
import {ProductDeleteComponent} from "./product/product-delete/product-delete.component";
import {CategoryListComponent} from "./category/category-list/category-list.component";
import {CategoryCreateComponent} from "./category/category-create/category-create.component";
import {CategoryEditComponent} from "./category/category-edit/category-edit.component";
import {CategoryDeleteComponent} from "./category/category-delete/category-delete.component";


const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'category/list', component: CategoryListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'category/create', component: CategoryCreateComponent},
  {path: 'product/edit/:id', component: ProductEditComponent},
  {path: 'category/edit/:id', component: CategoryEditComponent},
  {path: 'product/delete/:id', component: ProductDeleteComponent},
  {path: 'category/delete/:id', component: CategoryDeleteComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
