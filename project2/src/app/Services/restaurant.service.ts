import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Restaurant } from '../restaurant';
import { Observable } from 'rxjs';
import { HomepageComponent } from '../homepage/homepage.component';
import { checkAndUpdatePureExpressionInline } from '@angular/core/src/view/pure_expression';
import { Result } from '../Result';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private zomatoUrl = 'https://developers.zomato.com/api/v2.1/search?apikey=e44e4935c9867bb668311f76e5132541&entity_type=city&sort=rating&';  // URL to web api
  private zomatoRestaurantUrl = 'https://developers.zomato.com/api/v2.1/restaurant?apikey=e44e4935c9867bb668311f76e5132541&res_id=';

  results: any;
  Result: Result;

  constructor(
    private http: HttpClient,) { }

    //service to return list of restaurants
    getRestaurants(city: number, cuisine: number): Observable<Result> {
      return this.http.get<Result>(this.zomatoUrl+'entity_id='+city+'&cuisines='+cuisine);
    }

    //service to return restaurant by id
    getRestaurantbyId(restaurantId: number): Observable<Result> {
      return this.http.get<Result>(this.zomatoRestaurantUrl+restaurantId);
    }
}
