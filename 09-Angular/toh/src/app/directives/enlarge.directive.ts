import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Directive, ElementRef, Input, Output } from '@angular/core';

@Directive({
  selector: '[appColor]',
  // selector: '.enlarge'
  // selector: '#enlarge' // try this before belief. seeing is believing.
  // selector: 'enlarge'
  
})
export class ColoredDirective {
  constructor(el: ElementRef) {
    el.nativeElement.style.color = 'red'
   }

}
