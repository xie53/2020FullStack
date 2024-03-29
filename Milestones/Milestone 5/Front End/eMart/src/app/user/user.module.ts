import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { RegisterComponent } from './components/register/register.component';
import { BuyerSignupComponent } from './components/buyerSignup/buyerSignup.component';
import { SellerSignupComponent } from './components/sellerSignup/sellerSignup.component';
import { UserRoutingModule } from './user-routing.module';
import {SharedModule} from '../shared/shared.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [SignInComponent, RegisterComponent, BuyerSignupComponent, SellerSignupComponent],
  imports: [
    CommonModule,
    SharedModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    UserRoutingModule
  ]
})
export class UserModule { }
