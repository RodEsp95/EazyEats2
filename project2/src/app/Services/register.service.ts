import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(http: HttpClient) { }

  register(username: string, email: string, password: string, firstname: string, lastname: string, zipcode: string) {
    // method to checkk login 
  }

  updateProfile() {
    //method to update profile
  }
}
