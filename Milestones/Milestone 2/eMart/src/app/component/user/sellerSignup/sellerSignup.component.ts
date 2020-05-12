import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-sellerSignup',
  templateUrl: './sellerSignup.component.html',
  styleUrls: ['./sellerSignup.component.css']
})
export class SellerSignupComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.router.navigate(['/seller/addItem']);
  }

}
