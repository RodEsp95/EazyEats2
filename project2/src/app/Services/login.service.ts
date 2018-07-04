import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(http: HttpClient) { }

  

  logincheck(username: string, password: string) {
    // method to checkk login 
  } 
} 
