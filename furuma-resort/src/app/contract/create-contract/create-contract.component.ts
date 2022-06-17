import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../customer/customer.service';
import {Customer} from '../../model/customer';
import {Router} from '@angular/router';
import {ContractService} from '../contract.service';
import {Facility} from '../../model/facility';
import {FacilityService} from '../../facility/facility.service';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {

  createContractForm: FormGroup;

  customers: Customer[];

  facilities: Facility[];

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private facilityService: FacilityService,
              private router: Router) {
    this.createContractForm = new FormGroup({
      // id: new FormControl(),
      startDay: new FormControl(),
      endDay: new FormControl(),
      deposit: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      totalMoney: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      facility: new FormControl(),
      customer: new FormControl(),
    }, Validators.required);
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
    this.facilityService.getAll().subscribe(facilities => {
      this.facilities = facilities;
    });
  }

  create() {
    if (this.createContractForm.valid) {
      const contract = this.createContractForm.value;
      this.contractService.saveContract(contract).subscribe(() => {
        alert('Tạo hợp đồng thành công');
        this.createContractForm.reset();
        this.router.navigateByUrl('contract/list');
      }, e => console.log(e));
    }
  }

  // create() {
  //   const contract = this.createContractForm.value;
  //   this.contractService.saveContract(contract);
  //   this.createContractForm.reset();
  //   this.router.navigateByUrl('list-contract');
  // }
}
