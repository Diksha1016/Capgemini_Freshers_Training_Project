import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-movie',
  templateUrl: './book-movie.component.html',
  styleUrls: ['./book-movie.component.css']
})
export class BookMovieComponent implements OnInit {
  success: string;
  failure: string;
  seats = 0;
  total;
  usersName=null;
  userContact= null;
  theatersCity = null;
  usersId=null;
  constructor(private crudOperations: AuthenticationService,private router: Router) { }
  
  ngOnInit() {
    this.usersName = this.crudOperations.userName;
    this.userContact = this.crudOperations.contact;
    this.theatersCity = this.crudOperations.theaterCity;
    this.usersId = this.crudOperations.userId;
  }

  bookTicket(form: NgForm) {
    console.log(form,'data');  
    this.crudOperations.bookTicketData(form.value).subscribe(data => {
      if (data.statusCode === 201) {
        console.log(data);
        console.log(form.value);
        this.success = data.description;
        this.router.navigateByUrl('/payment');
         
      } else {
        console.log(data);
        this.failure = data.description;
      }
        setTimeout(() => {
          this.success = null;
          this.failure=null;
        }, 3000);
        form.reset();
      }
    );

}

}
