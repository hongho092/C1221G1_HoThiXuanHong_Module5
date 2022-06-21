import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[appHighLight]'
})
export class HighLightDirective {

  constructor(private elementRef: ElementRef) {
    this.elementRef.nativeElement.style.background = 'yellow';
  }

}
