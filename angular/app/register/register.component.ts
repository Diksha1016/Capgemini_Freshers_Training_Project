import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  success: string;
  failure: string;
  constructor(private crudOperations: AuthenticationService,private router:Router) { }
  ngOnInit() {
  }
  addUser(form: NgForm) {
    console.log(form);
    this.crudOperations.addUserData(form.value).subscribe(data => {
      if (data.statusCode === 201) {
        console.log(data);
        console.log(form.value);
        this.success = data.description; 
        this.router.navigateByUrl("/login")
      } else {
        console.log(data);
        this.failure = data.description;
      }
        setTimeout(() => {
          this.success = null;
          this.failure = null;
        }, 2000);
        form.reset();
      }
    );

}

}

