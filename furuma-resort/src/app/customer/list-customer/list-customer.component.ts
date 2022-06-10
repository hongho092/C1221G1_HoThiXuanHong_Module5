import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: Customer[] = [];

  customer: Customer;

  constructor() {
    this.customers.push({
      id: 1,
      name: 'Nguyễn Thị Hòa',
      gender: 'nữ',
      dateOfBirth: '1988/09/12',
      idCardNumber: '234567893',
      numberPhone: '0987654321',
      email: 'hoa@gmail.com',
      type: 'Diamond',
      address: 'Đà Nẵng',
      img: 'https://www.clipartmax.com/png/middle/71-717812_girl-person-woman-people-icon-profile-woman-icon.png'
    });
    this.customers.push({
      id: 2,
      name: 'Nguyễn Văn Nam',
      gender: 'nam',
      dateOfBirth: '1967/10/22',
      idCardNumber: '236757893',
      numberPhone: '0987654321',
      email: 'vnam@gmail.com',
      type: 'Platinium',
      address: 'Quảng Ngãi',
      img: 'data:image/png;base64,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'
    });
    this.customers.push({
      id: 3,
      name: 'Lê Văn Thành',
      gender: 'nam',
      dateOfBirth: '1984/03/27',
      idCardNumber: '234567999',
      numberPhone: '0778654321',
      email: 'thanhle@gmail.com',
      type: 'Gold',
      address: 'Hà Nam',
      img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWq645ljuDARZIzp-MKBBuUGRH5y8ynxpwPg&usqp=CAU'
    });
    this.customers.push({
      id: 4,
      name: 'Đào Thị Mơ',
      gender: 'nữ',
      dateOfBirth: '1995/04/23',
      idCardNumber: '234567893',
      numberPhone: '0987654321',
      email: 'hoa@gmail.com',
      type: 'Silver',
      address: 'Hà Nội',
      img: 'https://png.pngtree.com/element_our/png_detail/20181206/female-avatar-vector-icon-png_262142.jpg'
    });
    this.customers.push({
      id: 5,
      name: 'Hứa Văn Hùng',
      gender: 'nam',
      dateOfBirth: '1978/02/22',
      idCardNumber: '545567893',
      numberPhone: '0878754321',
      email: 'hunghua@gmail.com',
      type: 'Member',
      address: 'Sài Gòn',
      img: 'https://png.pngtree.com/png-clipart/20190924/original/pngtree-office-work-user-icon-avatar-png-image_4815124.jpg'
    });
  }

  ngOnInit(): void {
  }

  detailCustomer(customer: Customer) {
    this.customer = customer;
  }
}
