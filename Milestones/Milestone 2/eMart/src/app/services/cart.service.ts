import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  items = [];

  constructor(
    private http: HttpClient
  ) { }

  addToCart(product) {
    this.items.push(product);
  }

  gitItems() {
    return this.items;
  }

  deleteItem(product) {
    var index = this.items.indexOf(product); 
    if (index > -1) { 
      this.items.splice(index, 1); 
    }
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

}
