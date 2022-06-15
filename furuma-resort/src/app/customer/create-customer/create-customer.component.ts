import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import DateTimeFormat = Intl.DateTimeFormat;
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  createCustomerForm: FormGroup;

  constructor(private customerService: CustomerService,
              private router: Router) {
    this.createCustomerForm = new FormGroup({
      id: new FormControl(),
      code: new FormControl('', [Validators.pattern('^KH-[0-9]{4}$')]),
      name: new FormControl('', [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
      gender: new FormControl(),
      dateOfBirth: new FormControl(),
      idCardNumber: new FormControl('', [Validators.pattern('^([0-9]{9}|[0-9]{12})$')]),
      numberPhone: new FormControl('', [Validators.pattern('^(090|091)[0-9]{7}$')]),
      email: new FormControl('', [Validators.pattern('^[a-zA-Z1-9]+@gmail.com$')]),
      type: new FormControl(),
      address: new FormControl('', [Validators.pattern('^([A-Z][a-z]+ ?)*$')])
    }, Validators.required);
  }
  ngOnInit(): void {
  }

  create() {
    const customer = this.createCustomerForm.value;
    this.customerService.saveCustomer(customer);
    this.createCustomerForm.reset();
    this.router.navigateByUrl('list-customer');
  }
}
