import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DateagePipe } from './pipe/dateage.pipe';
import {ProductCardComponent} from './components/product-card';

@NgModule({
  declarations: [FooterComponent, NavbarComponent, DateagePipe, ProductCardComponent],
  imports: [
    CommonModule,
    NgbModule
  ],
  exports: [FooterComponent, NavbarComponent, DateagePipe, ProductCardComponent]
})
export class SharedModule { }
