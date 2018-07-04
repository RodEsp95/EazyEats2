import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../Services/review.service';
import { RestaurantService } from '../Services/restaurant.service';
import { Result } from '../Result';
import { restaurants } from '../restaurants';
import { Restaurant } from '../restaurant';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styles: [`
    .star {
      font-size: 1.5rem;
      color: #b0c4de;
    }
    .filled {
      color: #1e90ff;
    }
    .bad {
      color: #deb0b0;
    }
    .filled.bad {
      color: #ff1e1e;
    }
  `]
})
export class RestaurantComponent implements OnInit {

  currentRate: number = 0;
  result: Result;
  restaurant: restaurants;
  rest: Restaurant;
  id: number;
  private sub: any;

  constructor(private reviewservice: ReviewService, private restaurantservice: RestaurantService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];})
    this.displayRestaurant();
  }

  submitreview() {
    this.reviewservice.submitreview()
    //need to figure submit review method
    console.log("submit review method called")
  }

  displayRestaurant() {
      this.restaurantservice.getRestaurantbyId(this.id).subscribe(res => this.result = res);
      console.log(this.result);
  }

}
