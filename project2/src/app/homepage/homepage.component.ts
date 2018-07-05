import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../Services/restaurant.service';
import { Restaurant } from '../restaurant';
import { CityService } from '../Services/city.service';
import { City } from '../city';
import { Observable, Subject, of } from 'rxjs';
import { Result } from '../Result';
import { User } from '../user';
import { restaurants } from '../restaurants';
import { LoginService } from '../Services/login.service';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';



@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private restaurantservice: RestaurantService,
           private cityService: CityService,
           private loginservice: LoginService) { }

  search(term: string) {
    this.searchTerms.next(term);
  }
  
  ngOnInit() {
    console.log(this.loginservice.loggedin)
    this.cities$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the name
      debounceTime(300),
 
      // ignore new term if same as previous name
      distinctUntilChanged(),
 
      // switch to new search observable each time the term changes
      switchMap((term: string) => this.cityService.citysearch(term)),
    );
 
  }
  result: Result;
  city: number;
  cuisine: number; 
  loop: any;
  restaurants: restaurants;
  cities$: Observable<City[]>;
  private searchTerms = new Subject<string>();

  //method to show restaurants meeting URL in restaurant service
  showRestaurants(): void {
    this.restaurantservice.getRestaurants(this.city, this.cuisine).subscribe(res => this.result = res);

    console.log(this.result)
    console.log(this.result["restaurants"][0]["restaurant"]["name"])


    document.getElementById("restaurantTable").style.display = "table";
  }



}
