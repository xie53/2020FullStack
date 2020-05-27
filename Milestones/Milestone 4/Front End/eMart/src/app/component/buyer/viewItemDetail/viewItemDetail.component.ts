import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { products } from '../../../products';
import { CartService } from '../../../services/cart.service';

@Component({
  selector: 'app-viewItemDetail',
  templateUrl: './viewItemDetail.component.html',
  styleUrls: ['./viewItemDetail.component.css']
})
export class ViewItemDetailComponent implements OnInit {
  product;

  constructor(
    private route: ActivatedRoute,
    private cartService: CartService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.product = products[+params.get('productId')];
      }
    )
  }

  addToCart(product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
  }

}
