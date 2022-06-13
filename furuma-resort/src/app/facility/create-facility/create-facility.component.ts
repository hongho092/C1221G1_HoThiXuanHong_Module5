import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-facility',
  templateUrl: './create-facility.component.html',
  styleUrls: ['./create-facility.component.css']
})
export class CreateFacilityComponent implements OnInit {

  createFacilityForm: FormGroup;

  constructor() {
    this.createFacilityForm = new FormGroup({
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

  console() {
    console.log(this.createFacilityForm.value);
  }
}
