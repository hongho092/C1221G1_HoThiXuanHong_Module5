import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, ValidationErrors, ValidatorFn} from '@angular/forms';

@Component({
  selector: 'app-try',
  templateUrl: './try.component.html',
  styleUrls: ['./try.component.css']
})
export class TryComponent implements OnInit {

  confirmForm: FormGroup;

  constructor() {
    this.confirmForm = new FormGroup({
      a: new FormControl(),
      b: new FormControl()
    }, this.passwordErrorValidator);
  }


  passwordErrorValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const password = control.get('a');
    const repeatPassword = control.get('b');
    return password.value !== repeatPassword.value ? { passwordError: true } : null;
  }

  ngOnInit(): void {
  }

  createUser(value: any) {
    return null;
  }
}
