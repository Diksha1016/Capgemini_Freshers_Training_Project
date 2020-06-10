import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string;
  error;
  constructor(private auth: AuthenticationService,
              private router: Router) { }
    login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(response => {
    console.log(response);
    this.auth.userName = response.user[0].userName;
    this.auth.dateOfBirth = response.user[0].dateOfBirth;
    this.auth.contact = response.user[0].contact;
    this.auth.userId = response.user[0].userId;


    if (response.statusCode === 201) {
     this.message = response.description;
     localStorage.setItem('userDetails.userBean[0]', JSON.stringify(response));
     console.log(response.user);
     console.log('user details stored in local storage');
     this.router.navigateByUrl('/index');
    
    } else {
      console.log(response);
      this.error = response.description;
      }
     setTimeout(() => {
        this.message = null;
      }, 2000);

     form.reset();
    }
  );
}

ngOnInit() {
}
}

