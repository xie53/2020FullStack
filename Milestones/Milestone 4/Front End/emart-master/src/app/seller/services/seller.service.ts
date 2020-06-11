import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {Product} from '../../shared/domain';
import {ImageSlider, Manufacturer, SearchInventory} from '../domain';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json','Authorization': 'Basic ' + btoa("cloudsimpleservice:mysecret")  })
  // headers: new HttpHeaders({ 'Content-Type': 'application/json','Authorization': 'Basic Y2xvdWRzaW1wbGVzZXJ2aWNlOm15c2VjcmV0' })
};

@Injectable({
  providedIn: 'root'
})
export class SellerService {

constructor(private http: HttpClient) {}

getProducts(searchInventory: SearchInventory) {
  return this.http.get<Product[]>(`${environment.baseUrl}/seller-service/emart/seller/viewStock`,
    { params: new HttpParams()
              .set('itemName', String(searchInventory.itemName))});
}

postCreateItem(item) {
  return this.http.post(`${environment.baseUrl}/seller-service/emart/seller/addItems`, JSON.stringify(item), httpOptions);
}

}
