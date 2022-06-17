import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  editCustomerForm: FormGroup;
  id: number;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      customerService.findById(this.id).subscribe(customer => {
        this.editCustomerForm = new FormGroup({
          id: new FormControl(customer.id),
          code: new FormControl(customer.code, [Validators.pattern('^KH-[0-9]{4}$')]),
          name: new FormControl(customer.name, [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
          gender: new FormControl(customer.gender),
          dateOfBirth: new FormControl(customer.dateOfBirth),
          idCardNumber: new FormControl(customer.idCardNumber, [Validators.pattern('^([0-9]{9}|[0-9]{12})$')]),
          numberPhone: new FormControl(customer.numberPhone, [Validators.pattern('^(090|091)[0-9]{7}$')]),
          email: new FormControl(customer.email, [Validators.pattern('^[a-zA-Z1-9]+@gmail.com$')]),
          type: new FormControl(customer.type),
          address: new FormControl(customer.address, [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
          img: new FormControl(customer.img)
        });
      });
    });
  }

  ngOnInit(): void {
  }

  editCustomer(id: number) {
    const customer = this.editCustomerForm.value;
    this.customerService.editCustomer(id, customer).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('customer/list');
    });
  }
}
