import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../Services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registerservice: RegisterService) { }

  username: string;
  email: string;
  password: string;
  firstname: string;
  lastname: string;
  zipcode: string;

  ngOnInit() { 
  }

  register(username, email, password, firstname, lastname, zipcode): void {
    this.registerservice.register(username, email, password, firstname, lastname, zipcode)
    //need to figure out register method
    console.log("register method ran")
  }

}
