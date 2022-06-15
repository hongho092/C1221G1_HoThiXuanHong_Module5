import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility';
import {CustomerService} from '../../customer/customer.service';
import {FacilityService} from '../facility.service';

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {

  facilitys: Facility[] = [];

  constructor(facilityService: FacilityService) {
    this.facilitys = facilityService.getAll();
  }

  ngOnInit(): void {
  }

}
