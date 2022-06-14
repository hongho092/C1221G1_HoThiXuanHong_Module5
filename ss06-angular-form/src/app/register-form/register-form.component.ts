import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  registerForm: FormGroup;
  confirmForm: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl('abc@gmail.com', [Validators.email, Validators.required]),
      confirmForm: new FormGroup({
        password: new FormControl('', [Validators.required]),
        confirmPassword: new FormControl('', [Validators.required])
      }, this.passwordErrorValidator),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [this.validateCustomAge]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }

  validateCustomAge(age: AbstractControl) {
    const value = age.value;
    if (value < 18) {
      return {invalid: true};
    } else {
      return null;
    }
  }

  passwordErrorValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const password = control.get('password');
    const repeatPassword = control.get('confirmPassword');
    return password.value !== repeatPassword.value ? { passwordError: true } : null;
  }

  ngOnInit(): void {
  }

  console() {
    console.log(this.registerForm);
  }
}
