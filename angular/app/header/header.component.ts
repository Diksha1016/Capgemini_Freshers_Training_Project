import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthenticationService,
    private router: Router) { 

    }

  ngOnInit() {
  }

  bangaloreTheater(){
 console.log('in bangalore');
 this.authService.theaterCity='Bangalore';
 this.router.navigateByUrl("/show-alltheater");

  }
  kolkataTheater(){
    console.log('in kolkata');
    this.authService.theaterCity='Kolkata';
    this.router.navigateByUrl("/show-alltheater");
  }
  delhiTheater(){
    console.log('in delhi');
    this.authService.theaterCity='Delhi';
    this.router.navigateByUrl("/show-alltheater");
  }
  isLoggedIn() {
    
    let userDetails = JSON.parse(localStorage.getItem('userDetails.userBean[0]'));
    if(userDetails){
      return true;
    }else{
      return false;
    }
  }

  logout() {
    localStorage.removeItem('userDetails.userBean[0]');
    this.router.navigateByUrl('/');
  }

}
