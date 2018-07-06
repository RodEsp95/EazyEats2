import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../Services/register.service';
import { ProfileService } from '../Services/profile.service';
import { User } from '../user';
import { ReviewService } from '../Services/review.service';
import { RestaurantService } from '../Services/restaurant.service';
import { LoginService } from '../Services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private profileservice: ProfileService,
        private reviewservice: ReviewService,
        private restaurantservice: RestaurantService,
        private loginservice: LoginService) { }

  id = this.loginservice.id;

  username: string;
  email: string;
  password: string;
  name: string;
  status: string;

  User: any;
  Review: any;
  Restaurant: any

  loadProfile() {
    //console.log("userId="+this.loginservice.id);
    this.profileservice.getprofile(this.id).subscribe(res => this.User = res);
    console.log(this.User);
    //console.log("load Profile ran");
  }

  loadReviewsByUser() {
    this.reviewservice.loadreviewsbyuser(this.loginservice.id).subscribe(reviews => this.Review = reviews);
    console.log(this.Review)
  }

  updateProfile() {
    this.profileservice.updateProfile(this.loginservice.id, this.name, this.username, this.password, this.email, this.User.status)
    .subscribe(update => console.log("Update profile method ran: "+ update));
  }

  getRestaurantById(restId: number) {
    this.restaurantservice.getRestaurantbyId(restId).subscribe(res => this.Restaurant = res);
    console.log(this.Restaurant);
}

  ngOnInit() {
    this.loadProfile();
    this.loadReviewsByUser();
  }

}
 