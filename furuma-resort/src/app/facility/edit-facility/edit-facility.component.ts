import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../customer/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FacilityService} from '../facility.service';

@Component({
  selector: 'app-edit-facility',
  templateUrl: './edit-facility.component.html',
  styleUrls: ['./edit-facility.component.css']
})
export class EditFacilityComponent implements OnInit {

  editFacilityForm: FormGroup;

  constructor(private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.editFacilityForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl('', [Validators.pattern('^([A-Z][a-z]+ ?)*$')]),
      area: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      cost: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      maxPeople: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      type: new FormControl(),
      rentType: new FormControl(),
      standardRoom: new FormControl('', [Validators.pattern('^[1-9]{1}[0-9]*$')]),
      descriptionOtherConvenience: new FormControl()
    });
  }

  ngOnInit(): void {
  }

}
