import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Result } from '../result';
import { User } from '../user';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private url= "http://ec2-18-191-166-192.us-east-2.compute.amazonaws.com:8080/EazyEatsMVC/users"
  Result: Result;
  User: User;
  loggedin: boolean = false;
  id: number;

  logincheck(): Observable<Result> {
    // method to check login
    return this.http.get<Result>(this.url); 
  } 
}  
