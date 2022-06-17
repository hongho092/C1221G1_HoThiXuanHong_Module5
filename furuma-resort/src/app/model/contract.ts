import {Customer} from './customer';
import {Facility} from './facility';

export interface Contract {
  id: number;
  startDay: string;
  endDay: string;
  deposit: number;
  totalMoney: number;
  facility: Facility;
  customer: Customer;
}
