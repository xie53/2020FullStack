import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { products } from '../../../products';

@Component({
  selector: 'app-searchDetail',
  templateUrl: './searchDetail.component.html',
  styleUrls: ['./searchDetail.component.css']
})
export class SearchDetailComponent implements OnInit {
  products = products;

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  share() {
    window.alert('The product has been shared!');
  }

  itemDetail(productId) {
    sessionStorage.removeItem('token');
    this.router.navigate(['/buyer/products', productId]);
  }


}
