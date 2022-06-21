import {Directive, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appAppNot]'
})
export class AppNotDirective {

  constructor(private templateRef: TemplateRef<any>,
              private viewContainerRef: ViewContainerRef) {
  }

}
