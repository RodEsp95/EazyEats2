import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../Services/restaurant.service';
import { Restaurant } from '../restaurant';
import { CityService } from '../Services/city.service';
import { City } from '../city';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private restaurantservice: RestaurantService, private cityservice: CityService) { }

  ngOnInit() {
  }

  restaurants: Restaurant[];
  cities: City[];
  city: any;
  cuisine: string;

  //method to show restaurants meeting URL in restaurant service
  showRestaurants(city, cuisine): void {
    this.restaurantservice.getRestaurants(city, cuisine).subscribe(restaurants => this.restaurants = restaurants )
    //typeof(this.restaurants);
    console.log(this.restaurants);
  }

  // citySearch(): void {
  //   this.cityservice.citysearch().subscribe(cities => this.cities = cities);
  //   console.log(this.cities);
  // }

}
