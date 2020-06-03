import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { filter, map } from 'rxjs/operators';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  productId: string;
  ngOnInit(): void {
    this.route.params.subscribe(
      param => {
        this.productId = param.productId;
        // 通过productId获取具体商品详情
      }
    )
  }

}
