import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {

  color = "black";

  constructor() { }

  ngOnInit(): void {

  }

  changeColorValue(color) {
    this.color = color;
  }

}
