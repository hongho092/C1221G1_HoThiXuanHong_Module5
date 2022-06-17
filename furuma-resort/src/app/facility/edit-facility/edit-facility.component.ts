import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../customer/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FacilityService} from '../facility.service';
import {RentType} from '../../model/rent-type';
import {log} from 'util';

@Component({
  selector: 'app-edit-facility',
  templateUrl: './edit-facility.component.html',
  styleUrls: ['./edit-facility.component.css']
})
export class EditFacilityComponent implements OnInit {

  editFacilityForm: FormGroup;

  id: number;

  rentTypes: RentType[];

  equals(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      facilityService.findById(this.id).subscribe(facility => {
        this.editFacilityForm = new FormGroup({
          // id: new FormControl(facility.id),
          name: new FormControl(facility.name, [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
          area: new FormControl(facility.area, [Validators.pattern('^[1-9]{1}[0-9]*$')]),
          cost: new FormControl(facility.cost, [Validators.pattern('^[1-9]{1}[0-9]*$')]),
          maxPeople: new FormControl(facility.maxPeople, [Validators.pattern('^[1-9]{1}[0-9]*$')]),
          type: new FormControl(facility.type),
          rentType: new FormControl(facility.rentType),
          standardRoom: new FormControl(facility.standardRoom, [Validators.pattern('^[1-9]{1}[0-9]*$')]),
          descriptionOtherConvenience: new FormControl(facility.descriptionOtherConvenience),
          image: new FormControl(facility.image),
        });
      });
    });
  }

  ngOnInit(): void {
    this.facilityService.getAllRentType().subscribe(rentType => {
      this.rentTypes = rentType;
    });
    console.log(this.editFacilityForm);
  }

  editFacility(id: number) {
    const customer = this.editFacilityForm.value;
    this.facilityService.editFacility(id, customer).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('facility/list');
    });
  }
}
