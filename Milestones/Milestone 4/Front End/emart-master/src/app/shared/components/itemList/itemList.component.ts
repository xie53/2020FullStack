import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../../domain';

@Component({
  selector: 'app-itemList',
  templateUrl: './itemList.component.html',
  styleUrls: ['./itemList.component.css']
})
export class ItemListComponent implements OnInit {

  @Input() product: Item;
  constructor() { }

  ngOnInit() {
  }

}
