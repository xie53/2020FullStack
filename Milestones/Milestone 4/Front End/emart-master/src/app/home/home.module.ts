import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeDetailComponent } from './components/home-detail/home-detail.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {SharedModule} from '../shared/shared.module';


@NgModule({
  declarations: [HomeDetailComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    NgbModule,
    SharedModule
  ]
})
export class HomeModule { }
