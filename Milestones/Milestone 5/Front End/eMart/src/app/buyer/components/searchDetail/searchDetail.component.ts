import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { products } from '../../domain/products';
import { Item } from '../../../shared/domain';
import { Observable } from 'rxjs';
import { BuyerService } from '../../services/buyer.service';

@Component({
  selector: 'app-searchDetail',
  templateUrl: './searchDetail.component.html',
  styleUrls: ['./searchDetail.component.css']
})
export class SearchDetailComponent implements OnInit {
  // products = products;
  products: Observable<Item[]>;

  constructor(
    private router: Router,
    private buyerService: BuyerService
  ) { }

  ngOnInit() {
  }

  share() {
    window.alert('The product has been shared!');
  }

  itemDetail(productId) {
    // sessionStorage.removeItem('token');
    this.router.navigate(['/buyer/products', productId]);
    // this.router.navigate(['/buyer/viewItemDetail', productId]);
  }

  onSubmit(value: any) {
    console.log(value); // {name: "admin11", password: "321243132"}
    this.buyerService.getItemList(value).subscribe(
      data => {
        console.log(JSON.stringify(data));
        const info: any = data;
        if ("OK" === info.status) {
            this.products = info.result.itemInformationList;
            // this.products = info.result;
            console.log('商品查询成功！');
            console.log(info.result);
            console.log(info.result.itemInformationList);
            // this.alerts.push({type : 'info', message: 'Item creation success!'});
        } else if(200 != info.code) {
          console.log('商品查询失败！');
          // this.alerts.push({type : 'danger', message: 'User creation failed!'});
        } else {
          console.log('商品查询失败！');
          // this.alerts.push({type : 'danger', message: 'User creation failed!'});
        }
      }
    );
  }

}
