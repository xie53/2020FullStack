import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import {Item} from '../../../shared/domain';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  itemsInventory;
  // itemsInventory: Observable<Item[]>;
  // itemsInventory: any[];
  // itemsInventory2=[];
  // itemsInventory: Observable<any[]>;

  constructor(
    private http: HttpClient,
    private inventory: InventoryService
  ) { }

  ngOnInit() {
    // return this.http.get('/assets/productInventory.json');
    // this.itemsInventory = this.inventory.getProductInventory();
  }

  /* 检索操作 */
  onSubmit(value: any) {
    console.log(value);
    this.itemsInventory = this.inventory.getProductInventory(value);
    // console.log("xieys"+this.itemsInventory);
  
    // this.inventory.getProductInventory(value).subscribe(data => {
    //   console.log(JSON.stringify(data));
    //   const info: any = data;
    //   this.itemsInventory = info.result;
    //   // this.itemsInventory = info.result;
    //   console.log("xieys"+this.itemsInventory);
    // });

    // this.userService.postSignIn(value).subscribe(
    //   data => {
    //     console.log(JSON.stringify(data));
    //     const info: any = data;
    //     console.log(info.code);
    //     if ("OK" === info.status) {
    //       this.userService.postObtainToken(value).subscribe(
    //         data => {
    //           // console.log(JSON.stringify(data));
    //           const info2: any = data;
    //           console.log("xieys2:"+info2.access_token);
    //           sessionStorage.setItem('token', info2.access_token);
    //         }
    //         );

    //         console.log('登录成功，调转详情页');
    //         // this.router.navigate(['/home']);
    //         this.router.navigate(['/seller/inventory']);
    //     } else if(200 != info.code) {
    //       console.log('登录失败，弹出MSG');
    //       this.alerts.push({type : 'danger', message: 'username or password error!'});
    //     } else {
    //       console.log('登录失败，弹出MSG');
    //       this.alerts.push({type : 'danger', message: 'username or password error!'});
    //     }
    //   }
    // );



  }

}
