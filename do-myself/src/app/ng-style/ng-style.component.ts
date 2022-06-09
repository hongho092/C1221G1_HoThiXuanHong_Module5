import { Component, OnInit } from '@angular/core';
import {CssStyle} from '../css-style';

@Component({
  selector: 'app-ng-style',
  templateUrl: './ng-style.component.html',
  styleUrls: ['./ng-style.component.css']
})
export class NgStyleComponent implements OnInit {

  colorInput: string = 'purple';

  cssStyleValue = new CssStyle();

  constructor() { }

  ngOnInit(): void {
  }

}
