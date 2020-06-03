import {Component, OnInit, ViewChild} from '@angular/core';
import {NgbCarousel, NgbSlideEvent, NgbSlideEventSource} from '@ng-bootstrap/ng-bootstrap';
import {Manufacturer, SearchItem} from '../../domain';
import { Observable } from 'rxjs';
import {Product} from '../../../shared/domain';
import {HomeService} from '../../services/home.service';

@Component({
  selector: 'app-home-detail',
  templateUrl: './home-detail.component.html',
  styleUrls: ['./home-detail.component.css']
})
export class HomeDetailComponent implements OnInit {

  images = [1, 2, 3, 4].map((n) => `https://uhuodi-sharehtml.oss-cn-shanghai.aliyuncs.com/image/${n}.jpg`);

  paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;
  manufacturers: Manufacturer[];
  searchItem: SearchItem;
  products: Observable<Product[]>;

  @ViewChild('carousel', {static : true}) carousel: NgbCarousel;

  constructor(private service: HomeService) {}

  ngOnInit(): void {
    // this.manufacturers = [
    //   {name : 'THERMOS', id: 1},
    //   {name : 'FREIZ', id: 2},
    //   {name : 'CB JAPAN', id: 3}
    // ];
    this.service.getManufacturers().subscribe(data => {
      console.log(JSON.stringify(data));
      const manu: any = data;
      this.manufacturers = manu.result;
    });
    this.searchItem = {
      startPrice: '',
      endPrice: '',
      manufacturer: '',
    }
    // this.products$ = this.service.getProducts(this.searchItem);
    this.service.getProducts(this.searchItem).subscribe(data => {
      console.log(JSON.stringify(data));
      const info: any = data;
      this.products = info.result;
    });
  }

  togglePaused() {
    if (this.paused) {
      this.carousel.cycle();
    } else {
      this.carousel.pause();
    }
    this.paused = !this.paused;
  }

  onSlide(slideEvent: NgbSlideEvent) {
    if (this.unpauseOnArrow && slideEvent.paused &&
      (slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)) {
      this.togglePaused();
    }
    if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
      this.togglePaused();
    }
  }

  /* 检索操作 */
  onSubmit(value: any) {
    this.service.getProducts(value).subscribe(data => {
      console.log(JSON.stringify(data));
      const info: any = data;
      this.products = info.result;
    });
  }


}
