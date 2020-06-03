import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import {SharedModule} from '../shared/shared.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ProductComponent } from './components/product/product.component';


@NgModule({
  declarations: [ProductComponent],
  imports: [
    CommonModule,
    SharedModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    ProductRoutingModule
  ]
})
export class ProductModule { }
