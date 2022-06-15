import { Injectable } from '@angular/core';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  facilitys: Facility[] = [];

  constructor() {
    this.facilitys.push({
      id: 1,
      name: 'Room Twin',
      area: 564,
      cost: 4000000,
      maxPeople: 3,
      type: 'House',
      rentType: 'Day',
      standardRoom: 3,
      descriptionOtherConvenience: 'Có hồ bơi',
      review: 20,
      image: 'https://images.adsttc.com/media/images/629f/3517/c372/5201/650f/1c7f/large_jpg/hyde-park-house-robeson-architects_1.jpg?1654601149'
    });
    this.facilitys.push({
      id: 2,
      name: 'Villa Beach Front',
      area: 1264,
      cost: 5600000,
      maxPeople: 10,
      type: 'Villa',
      rentType: 'Month',
      standardRoom: 4,
      descriptionOtherConvenience: 'Có hồ bơi, ti vi',
      review: 15,
      image: 'https://e8rbh6por3n.exactdn.com/sites/uploads/2020/05/villa-la-gi-thumbnail.jpg?strip=all&lossy=1&ssl=1'
    });
    this.facilitys.push({
      id: 3,
      name: 'House Princess 02',
      area: 764,
      cost: 4500000,
      maxPeople: 5,
      type: 'House',
      rentType: 'Day',
      standardRoom: 4,
      descriptionOtherConvenience: 'Có ti vi',
      review: 9,
      image: 'https://media-cdn.tripadvisor.com/media/photo-s/1c/99/49/75/chi-house-danang-hotel.jpg'
    });
    this.facilitys.push({
      id: 4,
      name: 'House Princess 01',
      area: 566,
      cost: 40056000,
      maxPeople: 7,
      type: 'House',
      rentType: 'Year',
      standardRoom: 5,
      descriptionOtherConvenience: 'Có bếp nướng',
      review: 8,
      image: 'https://static.dezeen.com/uploads/2020/02/house-in-the-landscape-niko-arcjitect-architecture-residential-russia-houses-khurtin_dezeen_2364_hero.jpg'
    });
  }

  getAll() {
    return this.facilitys;
  }
}
