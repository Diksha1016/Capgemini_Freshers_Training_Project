import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-contact',
  templateUrl: './update-contact.component.html',
  styleUrls: ['./update-contact.component.css']
})
export class UpdateContactComponent implements OnInit {
  constructor(public userService: AuthenticationService,
    private router: Router) { }

updateContact(form: NgForm) {
this.userService.updateContact(form.value).subscribe(response => {
console.log(response);
if (response.statusCode === 201) {
this.router.navigateByUrl('/index');
}
form.reset();
});
}

ngOnInit() {
}

}
