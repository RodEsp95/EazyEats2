import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Restaurant } from '../restaurant';
import { Observable } from 'rxjs';
import { HomepageComponent } from '../homepage/homepage.component';
import { checkAndUpdatePureExpressionInline } from '@angular/core/src/view/pure_expression';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private zomatoUrl = 'https://developers.zomato.com/api/v2.1/search?apikey=e44e4935c9867bb668311f76e5132541&entity_type=city&';  // URL to web api
  // city_id; //city id for Abilene,TX
  // private cuisine_id; //cuisine id for vegetarian

  constructor(
    private http: HttpClient,) { }

    //service to return list of restaurants
    getRestaurants(city: number, cuisine: number): Observable<Restaurant[]> {
      return this.http.get<Restaurant[]>(this.zomatoUrl+'entity_id='+city+'&cuisines='+cuisine);
    }
}
