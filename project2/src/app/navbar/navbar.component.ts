import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginservice: LoginService) { }

  ngOnInit() {
    console.log(this.loginservice.loggedin)
  }

  logout() {
    if(this.loginservice.loggedin == true) {
      this.loginservice.loggedin = false;
    }
  }

}
