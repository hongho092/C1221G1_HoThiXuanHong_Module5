import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-info-customer',
  templateUrl: './info-customer.component.html',
  styleUrls: ['./info-customer.component.css']
})
export class InfoCustomerComponent implements OnInit {

  @Input() detailCustomer: Customer;

  constructor() { }

  ngOnInit(): void {
  }

}
