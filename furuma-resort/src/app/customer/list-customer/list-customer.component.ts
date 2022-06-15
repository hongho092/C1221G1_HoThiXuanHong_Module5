import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: Customer[] = [];

  customer: Customer;

  constructor(customerService: CustomerService) {
    this.customers = customerService.getAll();
  }

  ngOnInit(): void {
  }

  detailCustomer(customer: Customer) {
    this.customer = customer;
  }
}
