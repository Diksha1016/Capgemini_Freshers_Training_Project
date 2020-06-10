import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inox',
  templateUrl: './inox.component.html',
  styleUrls: ['./inox.component.css']
})
export class InoxComponent implements OnInit {
  movies: Movie[];

  constructor(private http:HttpClient) {
    this.getDataFromJSON();
   }

  ngOnInit() {
  }
  getDataFromJSON(){
    this.http.get<Movie[]>('../../assets/movie1.json').subscribe(response=>{
      console.log(response);
      this.movies = response;
    });
  }
}
interface Movie{
  name: string,
  image: string,
  screen1:string,
  showTime1:string,
  screen2:string,
  showTime2:string,
  screen3:string,
  showTime3:string
  
}

