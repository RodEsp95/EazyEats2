import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  private url = 'http://ec2-18-191-166-192.us-east-2.compute.amazonaws.com:8080/EazyEatsMVC/users/create';
  
  User: User;
  httpOptions: any;

  register(username: string, email: string, password: string, name: string): Observable<User> {
    // method to checkk login 
    return this.http.post<User>(this.url+'?name='+name+'&username='+username+'&password='+password+'&email='+email+'&status=Normal', User);
  }

  updateProfile() {
    //method to update profile
  }
}
