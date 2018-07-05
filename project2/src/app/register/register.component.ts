import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../Services/register.service';
import { User } from '../user';

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
  name: string;
  User: User;

  ngOnInit() { 
  }

  register(): void {
    this.registerservice.register(this.username, this.email, this.password, this.name).subscribe(res => this.User =res);
    console.log(this.User);
    console.log(this.username, this.email, this.name);
    //need to figure out register method
    console.log("register method ran")
  }

}
