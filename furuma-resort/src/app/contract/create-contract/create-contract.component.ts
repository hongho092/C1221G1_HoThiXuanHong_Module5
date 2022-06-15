import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../customer/customer.service';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {

  createContractForm: FormGroup;

  customers: Customer[];

  constructor(private customerService: CustomerService) {
    this.createContractForm = new FormGroup({
      id: new FormControl(),
      startDay: new FormControl(),
      endDay: new FormControl(),
      deposit: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      totalMoney: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      customer: new FormControl(),
    }, Validators.required);
  }

  ngOnInit(): void {
    this.customers = this.customerService.getAll();
  }

  create() {
    console.log(this.createContractForm.value);
  }
}
