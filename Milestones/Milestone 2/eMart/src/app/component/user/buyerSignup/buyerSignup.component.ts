import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-buyerSignup',
  templateUrl: './buyerSignup.component.html',
  styleUrls: ['./buyerSignup.component.css']
})
export class BuyerSignupComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.router.navigate(['/buyer/searchDetail']);
  }
}
