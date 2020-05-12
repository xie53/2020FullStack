import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

constructor(
  private http: HttpClient
  ) { }

  getProductInventory() {
    return this.http.get('/assets/productInventory.json');
  }
}
