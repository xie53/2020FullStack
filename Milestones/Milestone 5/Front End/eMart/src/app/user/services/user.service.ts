import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json','Authorization': 'Basic ' + btoa("cloudsimpleservice:mysecret")  })
  // headers: new HttpHeaders({ 'Content-Type': 'application/json','Authorization': 'Basic Y2xvdWRzaW1wbGVzZXJ2aWNlOm15c2VjcmV0' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public get currentUserToken(): string {
    return sessionStorage.getItem('token');
  }

  postSignIn(user) {
    // console.log("xieys: "+user.role);
    if ("buyer" === user.role) {
      // redirect buyerLogin api
      return this.http.get(`${environment.baseUrl}/user-service/emart/user/buyer/buyerLogin?userName=${user.name}&password=${user.password}`, httpOptions);
    } else {
      // redirect sellerLogin api
      return this.http.get(`${environment.baseUrl}/user-service/emart/user/seller/sellerLogin?userName=${user.name}&password=${user.password}`, httpOptions);
    }
  }

  postObtainToken(user) {
    return this.http.post(`${environment.baseUrl}/auth-service/auth/oauth/token?grant_type=password&scope=webclient&username=user&password=user`, JSON.stringify(user), httpOptions);
  }

  postBuyerSignUp(user) {
    return this.http.post(`${environment.baseUrl}/user-service/emart/user/buyer/buyerSignup`, JSON.stringify(user), httpOptions);
  }

  postSellerSignUp(user) {
    return this.http.post(`${environment.baseUrl}/user-service/emart/user/seller/sellerSignup`, JSON.stringify(user), httpOptions);
  }

}
