import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-for',
  templateUrl: './ng-for.component.html',
  styleUrls: ['./ng-for.component.css']
})
export class NgForComponent implements OnInit {

  // arr = ['angular', 'java', 'mysql'];

  arr = [['angular', 'java'], ['c#', 'typescript']];

  constructor() { }

  ngOnInit(): void {
  }

}
