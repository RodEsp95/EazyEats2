import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ReviewService } from '../Services/review.service';

@Component({
  selector: 'app-verifiedrequest',
  templateUrl: './verifiedrequest.component.html',
  styleUrls: ['./verifiedrequest.component.css']
})
export class VerifiedrequestComponent implements OnInit {

  constructor(private reviewservice: ReviewService) { }

  ngOnInit() {
  }

}
