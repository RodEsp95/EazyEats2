import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../Services/review.service';
import { review } from '../review'

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private reviewservice: ReviewService) {}

  review: any;
  list: any[];

  ngOnInit() {
    this.loadFlaggedReviews();
  }

  loadFlaggedReviews() {
    this.reviewservice.loadAllFlaggedReviews().subscribe(rev => this.review = rev)
    console.log(this.review);
    document.getElementById("reviewTable").style.display = "table";
  }

  deleteReview(id: number) {
    this.reviewservice.deleteReviews(id).subscribe(rev => console.log(rev));
  }

  dismissComplaint(id: number) {
    this.reviewservice.dismissFlagReview(id).subscribe(rev => console.log(rev));
  }
}
