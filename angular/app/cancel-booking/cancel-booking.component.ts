import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {
  success: string;
  bookings: any;
  failure: string;

  constructor(private userService: AuthenticationService, private router: Router) {
    this.getBookings();
  }

  getBookings() {
    console.log(this.userService.userId);
    this.userService.getBookingsData(this.userService.userId).subscribe(response => {
      console.log(response);
      this.bookings = response.book;
    }, err => {
      console.log(err);
    });
  }
  deleteBooking(booking: any) {
    this.userService.deleteBookingData(booking).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.bookings.splice(this.bookings.indexOf(booking), 1);
        this.success = response.description;
        this.router.navigateByUrl('/index');
      }else {

        this.failure = response.description;
      }
      setTimeout(() => {
        this.success = null;
        this.failure=null;
      }, 4000);
    });
  }

  deleteMessage() {
    this.success = null;
  }
  ngOnInit() {
  }

}
