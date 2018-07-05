import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient,) { }

  private url="http://ec2-18-191-166-192.us-east-2.compute.amazonaws.com:8080/EazyEatsMVC/users/"
  User: User;

getprofile(id: number): Observable<User> {
  return this.http.get<User>(this.url+id);
}

updateProfile(id: number, name: string, username: string, email: string, password: string, status: string): Observable<User> {
  return this.http.post<User>(this.url+id+'?name='+name+'&username='+username+'&password='+password+'&email='+email+'&status='+status, User);
}

}
