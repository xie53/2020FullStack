import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { SearchDetailComponent } from './components/searchDetail/searchDetail.component';
import { ViewItemDetailComponent } from './components/viewItemDetail/viewItemDetail.component';

const routes: Routes = [
  { path: 'buyer/cart', component: CartComponent },
  { path: 'buyer/searchDetail', component: SearchDetailComponent },
  { path: 'buyer/products/:productId', component: ViewItemDetailComponent}
  // { path: 'buyer/viewItemDetail', component: ViewItemDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BuyerRoutingModule { }
