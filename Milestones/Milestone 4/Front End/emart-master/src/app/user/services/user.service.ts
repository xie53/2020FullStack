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
    return this.http.post(`http://localhost:5555/api/auth-service/auth/oauth/token?grant_type=password&scope=webclient&username=admin&password=admin`, JSON.stringify(user), httpOptions);
  }

}
