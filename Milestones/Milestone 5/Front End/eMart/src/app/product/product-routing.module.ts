import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from './components/product/product.component';

const routes: Routes = [
  { path: 'products',
    children: [
      {
        path: ':productId',
        component: ProductComponent
      }
    ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }

