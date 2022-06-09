import {Component, OnInit} from '@angular/core';
import {Contract} from '../../model/contract';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  contracts: Contract[] = [];

  constructor() {
    this.contracts.push({id: 1, startDay: '2022/09/10', endDay: '2022/09/12', deposit: 670000, totalMoney: 4000000});
    this.contracts.push({id: 2, startDay: '2022/10/12', endDay: '2022/10/14', deposit: 896000, totalMoney: 6000000});
    this.contracts.push({id: 3, startDay: '2022/10/22', endDay: '2022/10/24', deposit: 879000, totalMoney: 3450000});
    this.contracts.push({id: 4, startDay: '2022/11/27', endDay: '2022/11/30', deposit: 342000, totalMoney: 2450000});
    this.contracts.push({id: 5, startDay: '2022/11/28', endDay: '2022/11/29', deposit: 564000, totalMoney: 6560000});
  }

  ngOnInit(): void {
  }

}
