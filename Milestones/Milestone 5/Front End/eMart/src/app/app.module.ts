import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {UserModule} from './user/user.module';
import {ProductModule} from './product/product.module';
import {HomeModule} from './home/home.module';
import {SellerModule} from './seller/seller.module';
import {BuyerModule} from './buyer/buyer.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    SharedModule,
    UserModule,
    ProductModule,
    HomeModule,
    SellerModule,
    BuyerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
