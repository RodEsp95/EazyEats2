import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../Services/review.service';
import { RestaurantService } from '../Services/restaurant.service';
import { Result } from '../Result';
import { restaurants } from '../restaurants';
import { Restaurant } from '../restaurant';
import { ActivatedRoute } from '@angular/router';
import { review } from '../review';
import { LoginService } from '../Services/login.service';

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
  restaurantId: number;
  private sub: any;
  review: review;
  rating: number;
  body:string;
  userId = this.loginservice.id;

  constructor(private reviewservice: ReviewService, 
    private restaurantservice: RestaurantService, 
    private route: ActivatedRoute,
    private loginservice: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.restaurantId = +params['id'];})
    this.displayRestaurant();
    this.loadReviewsByRestaurant();
  }

  submitreview(): void {
    this.reviewservice.submitreview(this.currentRate, this.body, this.userId, this.restaurantId).subscribe(rev => this.review = rev)
    console.log(this.review);
    //need to figure submit review method
    console.log("submit review method called")
    
  }

  displayRestaurant() {
      this.restaurantservice.getRestaurantbyId(this.restaurantId).subscribe(res => this.result = res);
      console.log(this.result);
  }

  loadReviewsByRestaurant() {
    this.reviewservice.loadreviewsbyrestaurantid(this.restaurantId).subscribe(rev => this.review = rev);
    console.log(this.review)
  }

}
