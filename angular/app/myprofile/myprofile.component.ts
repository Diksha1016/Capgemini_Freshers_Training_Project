import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';


@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent implements OnInit {
  userName=null;
  contact=null;
  dateOfBirth=null;
  constructor(private user: AuthenticationService) {
        this.userName = this.user.userName;
        this.dateOfBirth=this.user.dateOfBirth;
        this.contact=this.user.contact;
  }
  ngOnInit() {
    var data = {
      userName:this.userName,
      contact:this.contact,
      dateOfBirth:this.dateOfBirth
    }
    console.log(data); 

  }
  

}
