import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { review } from '../review';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }
  Review: review;

  private url='http://ec2-18-191-166-192.us-east-2.compute.amazonaws.com:8080/EazyEatsMVC/reviews';

  submitverifieduserrequest() {
    
  }

  loadreviewsbyuser(id: number): Observable<review> {
    return this.http.get<review>(this.url+'/byUser/'+id);
  }

  loadreviewsbyrestaurantid(id: number): Observable<review>{
    return this.http.get<review>(this.url+'/byRestaurant/'+id);
  }

  submitreview(rating: number, body: string, userId: number, restaurantId: number): Observable<review> {
    return this.http.post<review>(this.url+'/create?body='+body+'&rating='+rating+'&needsReview=false&userId='+userId+'&restaurantId='+restaurantId , review);
  }
}
 