import { Component, OnInit } from '@angular/core';
import { SellerService } from '../../services/seller.service';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-addItem',
  templateUrl: './addItem.component.html',
  styleUrls: ['./addItem.component.css']
})
export class AddItemComponent implements OnInit {
  alerts: Alert[];

  constructor(
    private sellerService: SellerService
  ) { 
    this.reset();
  }

  ngOnInit() {
  }

  onSubmit(value: any) {
    console.log(value);
    if (this.validInput(value)) {
      console.log(value); // {name: "admin11", password: "321243132"}
      this.sellerService.postCreateItem(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          console.log(info.code);
          if ("OK" === info.status) {
              console.log('商品创建成功，调转详情页');
              // this.router.navigate(['/seller/inventory']);
              // this.router.navigate(['/seller/addItem']);
              this.alerts.push({type : 'info', message: 'Item creation success!'});
              // this.reset();
              // $('#form').reset();
              // value = "";
          } else if(200 != info.code) {
            console.log('商品创建失败，弹出MSG');
            this.alerts.push({type : 'danger', message: 'User creation failed!'});
          } else {
            console.log('商品创建失败，弹出MSG');
            this.alerts.push({type : 'danger', message: 'User creation failed!'});
          }
        }
      );
    }
  }

  /* 验证输入项 */
  validInput(value: any): boolean {
    this.reset();
    let result = true
    if (!value.itemName) {
      this.alerts.push({type : 'danger', message: 'Item Name required!'});
      result = false;
    }

    if (!value.categoryId) {
      this.alerts.push({type : 'danger', message: 'Category required!'});
      result =  false;
    }

    if (!value.subcategoryId) {
      this.alerts.push({type : 'danger', message: 'Subcategory required!'});
      result =  false;
    }

    if (!value.price) {
      this.alerts.push({type : 'danger', message: 'Price required!'});
      result =  false;
    }
    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }

  reset() {
    this.alerts = Array.from(ALERTS);
  }

}
