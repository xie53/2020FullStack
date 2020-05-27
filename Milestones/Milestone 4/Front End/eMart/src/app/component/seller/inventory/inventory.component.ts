import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { InventoryService } from '../../../services/inventory.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  itemsInventory;

  constructor(
    private http: HttpClient,
    private inventory: InventoryService
  ) { }

  ngOnInit() {
    // return this.http.get('/assets/productInventory.json');
    this.itemsInventory = this.inventory.getProductInventory();
  }

}
