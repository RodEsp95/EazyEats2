import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../Services/login.service';
import { User } from '../user';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html',
  styleUrls: ['./modal-login.component.css']
})
export class ModalLoginComponent implements OnInit {

  closeResult: string;

  constructor(private modalService: NgbModal, private loginservice: LoginService) {}

  username: string;
  password: string;
  passwordcheck: string
  User: User;

  login(username, password): void {
    this.loginservice.logincheck(username, password)
    //need to figure out how to login
    console.log("login method ran")
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
