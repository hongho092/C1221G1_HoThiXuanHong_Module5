import {Component, OnInit} from '@angular/core';
import {Contract} from '../../model/contract';
import {ContractService} from '../contract.service';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  contracts: Contract[] = [];

  contract: Contract;

  p = 0;

  constructor(private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.contractService.getAll().subscribe(contracts => {
      this.contracts = contracts;
    });
  }

}
