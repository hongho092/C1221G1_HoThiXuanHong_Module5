import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../model/customer';
import {Observable} from 'rxjs';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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
        this.customerService.findById(Number(id)).subscribe(customer => {
          this.detailCustomer = customer;
        });
      }
    });
  }

  ngOnInit(): void {
  }
}
