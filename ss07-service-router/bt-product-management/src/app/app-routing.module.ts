import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


const routes: Routes = [
  {
    path: 'product',
    loadChildren: () => import('./product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'category',
    loadChildren: () => import('./category/category.module').then(module => module.CategoryModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}


// const routes: Routes = [
//   {path: '', component: ProductListComponent},
//   {path: 'category/list', component: CategoryListComponent},
//   {path: 'product/create', component: ProductCreateComponent},
//   {path: 'category/create', component: CategoryCreateComponent},
//   {path: 'product/edit/:id', component: ProductEditComponent},
//   {path: 'category/edit/:id', component: CategoryEditComponent},
//   {path: 'product/delete/:id', component: ProductDeleteComponent},
//   {path: 'category/delete/:id', component: CategoryDeleteComponent}
// ];
