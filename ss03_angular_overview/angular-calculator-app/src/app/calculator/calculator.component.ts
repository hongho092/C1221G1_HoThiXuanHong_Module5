import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  number1: number;

  number2: number;

  addition: number;

  subtraction: number;

  multiplication;

  division;

  constructor() { }

  ngOnInit(): void {
  }

  changNumber1(number1) {
    this.number1 = number1
    this.addition = this.number1 + this.number2;
    this.subtraction = this.number1 - this.number2;
    this.multiplication  = this.number1 * this.number2;
    this.division  = this.number1 / this.number2;
  }

  changNumber2(number2) {
    this.number2 = number2
    this.addition = this.number1 + this.number2;
    this.subtraction = this.number1 - this.number2;
    this.multiplication  = this.number1 * this.number2;
    this.division  = this.number1 / this.number2;
  }
}
