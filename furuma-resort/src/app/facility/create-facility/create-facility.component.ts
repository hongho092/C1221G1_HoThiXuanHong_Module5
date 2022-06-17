import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FacilityService} from '../facility.service';
import {Router} from '@angular/router';
import {RentType} from '../../model/rent-type';

@Component({
  selector: 'app-create-facility',
  templateUrl: './create-facility.component.html',
  styleUrls: ['./create-facility.component.css']
})
export class CreateFacilityComponent implements OnInit {

  createFacilityForm: FormGroup;

  rentTypes: RentType[];

  constructor(private facilityService: FacilityService,
              private router: Router) {
    this.createFacilityForm = new FormGroup({
      // id: new FormControl(),
      name: new FormControl('', [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
      area: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      cost: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      maxPeople: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      type: new FormControl(),
      rentType: new FormControl(),
      standardRoom: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      descriptionOtherConvenience: new FormControl()
    }, Validators.required);
  }

  ngOnInit(): void {
    this.facilityService.getAllRentType().subscribe(rentType => {
      this.rentTypes = rentType;
    });
  }

  create() {
    if (this.createFacilityForm.valid) {
      const facility = this.createFacilityForm.value;
      this.facilityService.saveFacility(facility).subscribe(() => {
        alert('Tạo dịch vụ thành công');
        this.createFacilityForm.reset();
        this.router.navigateByUrl('facility/list');
      }, e => console.log(e));
    }
  }
}
