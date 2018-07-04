import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../Services/restaurant.service';
import { Restaurant } from '../restaurant';
import { CityService } from '../Services/city.service';
import { City } from '../city';
import { Observable, of } from 'rxjs';
import { Result } from '../Result';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private restaurantservice: RestaurantService, private cityservice: CityService) { }

  ngOnInit() {
  }
  result: Result;
  city: number;
  cuisine: number; 

  //method to show restaurants meeting URL in restaurant service
  showRestaurants(): void {
    this.restaurantservice.getRestaurants(this.city, this.cuisine).subscribe(res => this.result = res);
    console.log(this.result);
    document.getElementById("restaurantTable").style.display = "table";
  }

}
