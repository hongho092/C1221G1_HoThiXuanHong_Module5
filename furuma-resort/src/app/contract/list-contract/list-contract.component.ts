import {Component, OnInit} from '@angular/core';
import {Contract} from '../../model/contract';
import {ContractService} from '../contract.service';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  contracts: Contract[] = [];

  constructor(contractService: ContractService) {
    this.contracts = contractService.getAll();
  }

  ngOnInit(): void {
  }

}
