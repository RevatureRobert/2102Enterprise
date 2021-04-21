import { Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-sample-one',
  templateUrl: './sample-one.component.html',
  styleUrls: ['./sample-one.component.css']
})
export class SampleOneComponent implements OnInit, OnDestroy, OnChanges, DoCheck {

  constructor() {
    console.log("the component is instantiated");
   }
  ngOnDestroy(): void {
    console.log("the component is bye bye");
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log("The component has changed itself");
  }
  ngDoCheck(): void {
    console.log("The component feels a change in the force");
  }

  ngOnInit(): void {
    console.log("classic init, Ha!");
  }

}
