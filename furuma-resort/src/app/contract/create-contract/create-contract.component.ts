import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {

  createContractForm: FormGroup;

  constructor() {
    this.createContractForm = new FormGroup({
      id: new FormControl(),
      startDay: new FormControl(),
      endDay: new FormControl(),
      deposit: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      totalMoney: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
    });
  }

  ngOnInit(): void {
  }

}
