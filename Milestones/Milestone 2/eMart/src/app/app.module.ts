import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './component/user/login/login.component';
import { BuyerSignupComponent } from './component/user/buyerSignup/buyerSignup.component';
import { SellerSignupComponent } from './component/user/sellerSignup/sellerSignup.component';
import { SearchDetailComponent } from './component/buyer/searchDetail/searchDetail.component';
import { ViewItemDetailComponent } from './component/buyer/viewItemDetail/viewItemDetail.component';
import { CartComponent } from './component/buyer/cart/cart.component';
import { InventoryComponent } from './component/seller/inventory/inventory.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    BuyerSignupComponent,
    SellerSignupComponent,
    SearchDetailComponent,
    ViewItemDetailComponent,
    CartComponent,
    InventoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    // NgbModule,
    NgbAlertModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
