import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignInComponent} from './components/sign-in/sign-in.component';
import {RegisterComponent} from './components/register/register.component';
import { BuyerSignupComponent } from './components/buyerSignup/buyerSignup.component';
import { SellerSignupComponent } from './components/sellerSignup/sellerSignup.component';


const routes: Routes = [
  { path: 'sign-in', component: SignInComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'buyer/signup', component: BuyerSignupComponent },
  { path: 'seller/signup', component: SellerSignupComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
