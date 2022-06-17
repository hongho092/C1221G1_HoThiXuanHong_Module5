import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility';
import {FacilityService} from '../facility.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {

  facilities: Facility[] = [];

  facility: Facility;

  idDelete: number;

  nameDelete: string;

  p = 0;

  constructor(private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.facilityService.getAll().subscribe(facilities => {
      this.facilities = facilities;
    });
  }

  info(id: number, name: string) {
    this.idDelete = id;
    this.nameDelete = name;
  }

  delete(id: number) {
    this.facilityService.deleteFacility(id).subscribe(() => {
      this.ngOnInit();
    }, e => console.log(e));
  }

}
