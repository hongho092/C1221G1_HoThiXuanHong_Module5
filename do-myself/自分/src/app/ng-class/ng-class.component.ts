import { Component, OnInit } from '@angular/core';
import {CssClass} from '../css-class';

@Component({
  selector: 'app-ng-class',
  templateUrl: './ng-class.component.html',
  styleUrls: ['./ng-class.component.css']
})
export class NgClassComponent implements OnInit {

  cssStringVar = 'colorBlue size20px';

  cssClass = new CssClass();

  constructor() { }

  ngOnInit(): void {
  }

}
