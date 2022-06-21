import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  dateValue = '2021-01-31';
  textValue = 'Ho Hong';

  constructor() { }

  ngOnInit(): void {
  }

}
