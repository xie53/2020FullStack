import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './component/user/login/login.component';
import { BuyerSignupComponent } from './component/user/buyerSignup/buyerSignup.component';
import { SellerSignupComponent } from './component/user/sellerSignup/sellerSignup.component';
import { AddItemComponent } from './component/seller/addItem/addItem.component';
import { InventoryComponent } from './component/seller/inventory/inventory.component';
import { SearchDetailComponent } from './component/buyer/searchDetail/searchDetail.component';
import { ViewItemDetailComponent } from './component/buyer/viewItemDetail/viewItemDetail.component';
import { CartComponent } from './component/buyer/cart/cart.component';


const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'buyer/signup', component: BuyerSignupComponent},
  { path: 'seller/signup', component: SellerSignupComponent},
  { path: 'seller/addItem', component: AddItemComponent},
  { path: 'seller/inventory', component: InventoryComponent},
  { path: 'buyer/searchDetail', component: SearchDetailComponent},
  { path: 'buyer/products/:productId', component: ViewItemDetailComponent},
  { path: 'buyer/cart', component: CartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
