import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeDetailComponent} from './components/home-detail/home-detail.component';


const routes: Routes = [
  { path: 'home', component: HomeDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
