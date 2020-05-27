import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eMart Shipping';
  constructor(private router: Router) {}

  handleNavClick($event: string) {
    console.log("xxxxxxxx");
    this.router.navigate([$event]);

  }
}
