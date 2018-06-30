import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../Services/review.service';

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

  constructor(private reviewservice: ReviewService) { }

  ngOnInit() {
  }

  submitrating() {
    this.reviewservice.submitrating()
    //need to figure submit rating method
    console.log("submit rating method called")
  }

  submitreview() {
    this.reviewservice.submitreview()
    //need to figure submit review method
    console.log("submit review method called")
  }

}
