import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structure-array-example',
  templateUrl: './structure-array-example.component.html',
  styleUrls: ['./structure-array-example.component.css'],
})
export class StructureArrayExampleComponent implements OnInit {

  dayOfTheWeek: days = days.SUNDAY;

  arr = [
    'pizza',
    'cabbage',
    'popsicles',
    'dirt'
  ]
  constructor() {
   }
  ngOnInit(): void {
  }

 
}
export enum days {
      MONDAY = 'MONDAY',
      TUESDAY = 'TUESDAY',
      WEDNESDAY = 'WEDNESDAY',
      THURSDAY = 'THURSDAY',
      FRIDAY = 'FRIDAY',
      SATURDAY = 'SATURDAY',
      SUNDAY = 'SUNDAY'
}


interface something {
  one:number;
  two:string;
}