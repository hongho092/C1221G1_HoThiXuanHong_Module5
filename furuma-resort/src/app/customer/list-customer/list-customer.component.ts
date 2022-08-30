import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../customer.service';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: Customer[] = [];

  customer: Customer;

  idDelete: number;

  nameDelete: string;

  p = 0;

  searchNameForm: FormGroup;

  constructor(private customerService: CustomerService,
              private router: Router) {
    this.searchNameForm = new FormGroup({
      searchName: new FormControl(),
      searchAddress: new FormControl(),
      searchType: new FormControl()
    });
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }

  info(id: number, name: string) {
    this.idDelete = id;
    this.nameDelete = name;
  }

  delete(id: number) {
    this.customerService.deleteCustomer(id).subscribe(() => {
      this.ngOnInit();
    }, e => console.log(e));
  }

  search() {
    if (this.searchNameForm.value.searchName == null) {
      this.searchNameForm.value.searchName = '';
    }
    if (this.searchNameForm.value.searchAddress == null) {
      this.searchNameForm.value.searchAddress = '';
    }
    if (this.searchNameForm.value.searchType == null) {
      this.searchNameForm.value.searchType = '';
    }
    console.log(this.searchNameForm.value.searchName);
    console.log(this.searchNameForm.value.searchAddress);
    console.log(this.searchNameForm.value.searchType);
    this.customerService.searchCustomer(this.searchNameForm.value.searchName,
                                        this.searchNameForm.value.searchAddress,
                                        this.searchNameForm.value.searchType).subscribe(customers => {
                                        this.customers = customers;
    });
  }
}
