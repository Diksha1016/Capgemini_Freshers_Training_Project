import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { MyprofileComponent } from './myprofile/myprofile.component';
import { LogoutComponent } from './logout/logout.component';
import { TrendingShowsComponent } from './trending-shows/trending-shows.component';
import { IndexComponent } from './index/index.component';
import { UpdateContactComponent } from './update-contact/update-contact.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PaymentComponent } from './payment/payment.component';
import { TextMaskModule } from 'angular2-text-mask';
import { ShowAlltheaterComponent } from './show-alltheater/show-alltheater.component';
import { IylexComponent } from './iylex/iylex.component';
import { TheatersPipe } from './theaters.pipe';
import { InoxComponent } from './inox/inox.component';
import { BookMovieComponent } from './book-movie/book-movie.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactUsComponent,
    PageNotFoundComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent,
    ForgotPasswordComponent,
    MyprofileComponent,
    LogoutComponent,
    TrendingShowsComponent,
    IndexComponent,
    UpdateContactComponent,
    PaymentComponent,
    ShowAlltheaterComponent,
    IylexComponent,
    TheatersPipe,
    InoxComponent,
    BookMovieComponent,
    CancelBookingComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    TextMaskModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'logout', component: LogoutComponent },
      { path: 'contact-us', component: ContactUsComponent },
      { path: 'index', component: IndexComponent },
      { path: 'forgot-password', component: ForgotPasswordComponent },
      { path: 'myprofile', component: MyprofileComponent},
      { path: 'payment', component: PaymentComponent},
      { path: 'book-movie', component: BookMovieComponent },
      { path: 'cancel-booking', component: CancelBookingComponent },
       { path: 'trending-shows', component: TrendingShowsComponent },
       { path: 'update-contact', component: UpdateContactComponent},  
       { path: 'show-alltheater', component:ShowAlltheaterComponent}, 
       { path: 'iylex', component:IylexComponent},
       { path: 'inox', component:InoxComponent},
      { path: '**', component: PageNotFoundComponent }
    ]),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
