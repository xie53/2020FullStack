import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddItemComponent } from './components/addItem/addItem.component';
import { InventoryComponent } from './components/inventory/inventory.component';


const routes: Routes = [
  { path: 'seller/addItem', component: AddItemComponent },
  { path: 'seller/inventory', component: InventoryComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SellerRoutingModule { }
