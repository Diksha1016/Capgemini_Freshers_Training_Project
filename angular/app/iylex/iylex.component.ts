import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-iylex',
  templateUrl: './iylex.component.html',
  styleUrls: ['./iylex.component.css']
})
export class IylexComponent implements OnInit {
movies:Movie[];
  constructor(private http:HttpClient) { this.getDataFromJSON();}
  ngOnInit() {
  }
  getDataFromJSON(){
    this.http.get<Movie[]>(`../../assets/movie.json`).subscribe(response=>{
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
