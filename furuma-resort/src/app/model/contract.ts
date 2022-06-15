import {Customer} from './customer';

export interface Contract {
  id: number;
  startDay: string;
  endDay: string;
  deposit: number;
  totalMoney: number;
  customer: Customer;
}
