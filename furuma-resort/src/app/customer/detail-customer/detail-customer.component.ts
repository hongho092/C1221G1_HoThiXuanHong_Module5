import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-detail-customer',
  templateUrl: './detail-customer.component.html',
  styleUrls: ['./detail-customer.component.css']
})
export class DetailCustomerComponent implements OnInit {

  detailCustomer: Customer;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      if (id != null) {
        this.detailCustomer = customerService.findById(Number(id));
      }
    });
  }

  ngOnInit(): void {
  }

}
