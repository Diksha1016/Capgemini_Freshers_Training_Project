import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'theaters'
})
export class TheatersPipe implements PipeTransform {

  transform(theaters: Theater[], search: string): Theater[] {
    if (search === undefined) {
      return theaters;
  }
    return theaters.filter((theater, _index) => {
    return theater.theaterName.toLowerCase().includes(search.toLowerCase());
  });
}
}
