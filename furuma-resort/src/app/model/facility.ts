import {RentType} from './rent-type';

export interface Facility {
  id: number;
  name: string;
  area: number;
  cost: number;
  maxPeople: number;
  type: string;
  rentType: RentType;
  standardRoom: number;
  descriptionOtherConvenience: string;
  review: number;
  image?: string;
}
