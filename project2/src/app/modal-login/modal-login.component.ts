import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../Services/login.service';
import { User } from '../user';
import { Result } from '../result';
import { RegisterService } from '../Services/register.service';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html',
  styleUrls: ['./modal-login.component.css']
})
export class ModalLoginComponent implements OnInit {

  closeResult: string;

  constructor(private modalService: NgbModal, 
    private loginservice: LoginService) {}

  username: string;
  email: string;
  password: any;
  name: string;
  zipcode: number;
  loggedin = false;
  userId: number;

  passwordcheck: string
  User: any;
  result: any;

  login(): void {
    this.loginservice.logincheck().subscribe(res => this.result = res); 
     console.log(this.result);
    
     for(let loop of this.result) {
        if(loop.username == this.username && loop.password == this.password){
          console.log("logged in succesfully")
          console.log(loop.id)
          console.log(loop.status);
          this.loginservice.loggedin = true;
          this.loginservice.id = loop.id;
          this.loginservice.UserStatus = loop.status;
          break;
        }
     }
     console.log("User is logged in: " + this.loginservice.loggedin);
  }  


  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else { 
      return  `with: ${reason}`;
    }
  }

  ngOnInit() {
  }

}
