import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {Product} from '../../shared/domain';
import {ImageSlider, Manufacturer, SearchItem} from '../domain';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private http: HttpClient) {}

  getBanners() {
    return this.http.get<ImageSlider[]>(`${environment.baseUrl}/banners`);
  }

  getProducts(searchItem: SearchItem) {
    return this.http.get<Product[]>(`${environment.baseUrl}/products`,
      { params: new HttpParams()
                .set('startPrice', String(searchItem.startPrice))
                .set('endPrice', String(searchItem.endPrice))
                .set('manufacturer', searchItem.manufacturer)});
  }

  getManufacturers() {
    return this.http.get<Manufacturer[]>(`${environment.baseUrl}/seller-service/emart/seller/viewStock?itemName=iphone10`);
    // return this.http.get<Manufacturer[]>(`${environment.baseUrl}/manufacturer`);
  }
}
