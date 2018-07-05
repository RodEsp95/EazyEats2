import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { City } from '../city';
import { Observable, of, ObservableLike } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private zomatoUrl = 'https://developers.zomato.com/api/v2.1/cities?apikey=e44e4935c9867bb668311f76e5132541&q=';  // URL to web api

  constructor( private http: HttpClient,) { }

  //Service to view city with above url constants
  citysearch(cityName: string): Observable<City[]>{
    return this.http.get<City[]>(this.zomatoUrl+cityName);
  }


}
