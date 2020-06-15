import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import { Router } from '@angular/router';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {

  alerts: Alert[];

  constructor(private userService: UserService, private router: Router) {
    this.reset();
  }

  ngOnInit(): void {
    if (sessionStorage.getItem('token')) {
      this.router.navigate(['/sign-in']);
    }
  }

  /* 登录操作 */
  onSubmit(value: any) {
    if (this.validInput(value)) {
      console.log(value); // {name: "admin11", password: "321243132"}
      this.userService.postSignIn(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          console.log(info.code);
          if ("OK" === info.status) {
            this.userService.postObtainToken(value).subscribe(
              data => {
                // console.log(JSON.stringify(data));
                const info2: any = data;
                console.log("xieys2:"+info2.access_token);
                sessionStorage.setItem('token', info2.access_token);
              }
              );

              console.log('登录成功，调转详情页');
              // this.router.navigate(['/home']);
              if ("buyer" === value.role) {
                this.router.navigate(['/buyer/searchDetail']);
              } else if ("seller" === value.role) {
                this.router.navigate(['/seller/inventory']);
              }
          } else if(200 != info.code) {
            console.log('登录失败，弹出MSG');
            this.alerts.push({type : 'danger', message: 'username or password error!'});
          } else {
            console.log('登录失败，弹出MSG');
            this.alerts.push({type : 'danger', message: 'username or password error!'});
          }
        }
      );
    }
  }

  /* 验证输入项 */
  validInput(value: any): boolean {
    this.reset();
    let result = true
    if (!value.name) {
      this.alerts.push({type : 'danger', message: 'username required!'});
      result = false;
    }

    if (!value.password) {
      this.alerts.push({type : 'danger', message: 'password required!'});
      result =  false;
    }

    if (value.password.length < 6) {
      this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
      result =  false;
    }

    if (!value.role) {
      this.alerts.push({type : 'danger', message: 'choose role required!'});
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

  onClick() {
    console.log('onclick');
  }
}
