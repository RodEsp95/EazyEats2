import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../Services/register.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private profileservice: RegisterService) { }

  updateProfile() {
    this.profileservice.updateProfile();
    console.log("profile update method has been run")
  }

  ngOnInit() {
  }

}
 