import {Component, DoCheck, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, DoCheck {

  constructor(private router: Router) { }

   isSignin: boolean;

  ngOnInit(): void {
  //   if (sessionStorage.getItem('token')){
  //     this.isSignin = true;
  //   } else {
  //     this.isSignin = false;
  //   }
  }

  ngDoCheck(): void {
  //   console.log('docheck123');
  //   if (sessionStorage.getItem('token')){
  //     this.isSignin = true;
  //   } else {
  //     this.isSignin = false;
  //   }
  }

  signOut() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}
