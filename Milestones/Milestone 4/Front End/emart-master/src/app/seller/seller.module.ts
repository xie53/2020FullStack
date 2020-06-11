import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddItemComponent } from './components/addItem/addItem.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { SellerRoutingModule } from './seller-routing.module';
import {SharedModule} from '../shared/shared.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [AddItemComponent, InventoryComponent],
  imports: [
    CommonModule,
    SharedModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    SellerRoutingModule
  ]
})
export class SellerModule { }
