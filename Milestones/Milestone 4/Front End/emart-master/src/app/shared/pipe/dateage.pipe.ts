import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateage'
})
export class DateagePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
