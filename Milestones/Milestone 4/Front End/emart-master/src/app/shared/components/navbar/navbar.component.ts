import {Component, DoCheck, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, DoCheck {

  @Output() navClick = new EventEmitter<string>();

  constructor(private router: Router) { }

   isSignin: boolean;

  ngOnInit(): void {
    if (sessionStorage.getItem('token')){
      this.isSignin = true;
    } else {
      this.isSignin = false;
    }
  }

  ngDoCheck(): void {
    console.log('docheck');
    if (sessionStorage.getItem('token')){
      this.isSignin = true;
    } else {
      this.isSignin = false;
    }
  }

  signOut() {
    sessionStorage.removeItem('token');
    this.router.navigate(['sign-in']);
  }

  viewProducts(){
    this.navClick.emit('products');
  }

  signIn() {
    // this.navClick.emit('sign-in');
  }

  register() {
    this.navClick.emit('register');
  }
}
