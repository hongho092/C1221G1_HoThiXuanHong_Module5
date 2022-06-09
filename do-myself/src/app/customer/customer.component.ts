import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[] = [
    {customerNo: 1, name: 'Nguyen Van A', address: 'Hai Chau', city: 'Da Nang', country: 'Viet Nam', state: 'mien Trung'},
    {customerNo: 2, name: 'Nguyen Van B', address: 'Lien Chieu', city: 'Da Nang', country: 'Viet Nam', state: 'mien Trung'},
    {customerNo: 3, name: 'Nguyen Van C', address: 'Tam Ky', city: 'Quang Nam', country: 'Viet Nam', state: 'mien Trung'},
    {customerNo: 4, name: 'Nguyen Van D', address: 'Hoi An', city: 'Quang Nam', country: 'Viet Nam', state: 'mien Trung'}
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
