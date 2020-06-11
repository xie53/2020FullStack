import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartComponent } from './components/cart/cart.component';
import { SearchDetailComponent } from './components/searchDetail/searchDetail.component';
import { ViewItemDetailComponent } from './components/viewItemDetail/viewItemDetail.component';
import { BuyerRoutingModule } from './buyer-routing.module';
import {SharedModule} from '../shared/shared.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [CartComponent, SearchDetailComponent, ViewItemDetailComponent],
  imports: [
    CommonModule,
    SharedModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    BuyerRoutingModule
  ]
})
export class BuyerModule { }
