import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-sellerSignup',
  templateUrl: './sellerSignup.component.html',
  styleUrls: ['./sellerSignup.component.css']
})
export class SellerSignupComponent implements OnInit {

  alerts: Alert[];

  constructor(
    private router: Router,
    private userService: UserService
  ) { 
    this.reset();
  }

  ngOnInit() {
  }

  onSubmit(value: any) {
    console.log(value);
    if (this.validInput(value)) {
      console.log(value); // {name: "admin11", password: "321243132"}
      this.userService.postSellerSignUp(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          console.log(info.code);
          if ("OK" === info.status) {
              console.log('用户创建成功，调转详情页');
              this.router.navigate(['/seller/inventory']);
              // this.router.navigate(['/seller/addItem']);
          } else if(200 != info.code) {
            console.log('用户创建失败，弹出MSG');
            this.alerts.push({type : 'danger', message: 'User creation failed!'});
          } else {
            console.log('用户创建失败，弹出MSG');
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
    if (!value.userName) {
      this.alerts.push({type : 'danger', message: 'User Name required!'});
      result = false;
    }

    if (!value.password) {
      this.alerts.push({type : 'danger', message: 'Password required!'});
      result =  false;
    }

    if (value.password.length < 6) {
      this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
      result =  false;
    }

    if (!value.company) {
      this.alerts.push({type : 'danger', message: 'Company required!'});
      result =  false;
    }

    if (!value.contactNumber) {
      this.alerts.push({type : 'danger', message: 'Mobile Number required!'});
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
