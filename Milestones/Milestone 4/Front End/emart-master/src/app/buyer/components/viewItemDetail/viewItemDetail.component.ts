import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';

import { Item } from '../../../shared/domain';
import { Observable } from 'rxjs';
import { products } from '../../domain/products';
import { BuyerService } from '../../services/buyer.service';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-viewItemDetail',
  templateUrl: './viewItemDetail.component.html',
  styleUrls: ['./viewItemDetail.component.css']
})
export class ViewItemDetailComponent implements OnInit {
  // product;
  products: Observable<Item[]>;

  constructor(
    private route: ActivatedRoute,
    private route2: Router,
    private cartService: CartService,
    private buyerService: BuyerService
  ) { }

  
  productId: string;
  ngOnInit(): void {
    this.route.params.subscribe(
      param => {
        this.productId = param.productId;
        // 通过productId获取具体商品详情
        this.buyerService.getItem(this.productId).subscribe(
          data => {
            console.log(JSON.stringify(data));
            const info: any = data;
            if ("OK" === info.status) {
                this.products = info.result.itemInformationList;
                // this.products = info.result;
                console.log('商品详情页面显示成功！');
                console.log(info.result);
                console.log(info.result.itemInformationList);
                // this.alerts.push({type : 'info', message: 'Item creation success!'});
            } else if(200 != info.code) {
              console.log('商品详情页面显示失败！');
              // this.alerts.push({type : 'danger', message: 'User creation failed!'});
            } else {
              console.log('商品详情页面显示失败！');
              // this.alerts.push({type : 'danger', message: 'User creation failed!'});
            }
          }
        );


      }
    )
  }

  // ngOnInit() {
  //   this.route.paramMap.subscribe(
  //     params => {
  //       this.product = products[+params.get('productId')];
  //     }
  //   )
  // }


  onSubmit(value: any) {
    console.log(value); // {name: "admin11", password: "321243132"}
    this.route2.navigate(['/buyer/checkout', value]);
      // this.buyerService.postBuyerSignUp(value).subscribe(
      //   data => {
      //     console.log(JSON.stringify(data));
      //     const info: any = data;
      //     console.log(info.code);
      //     if ("OK" === info.status) {
      //         console.log('用户创建成功，调转详情页');
              // this.router.navigate(['/buyer/searchDetail']);
      //     } else if(200 != info.code) {
      //       console.log('用户创建失败，弹出MSG');
      //       // this.alerts.push({type : 'danger', message: 'User creation failed!'});
      //     } else {
      //       console.log('用户创建失败，弹出MSG');
      //       // this.alerts.push({type : 'danger', message: 'User creation failed!'});
      //     }
      //   }
      // );
  }


  addToCart(product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
  }

}
