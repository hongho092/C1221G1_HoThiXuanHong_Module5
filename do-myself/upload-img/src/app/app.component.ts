// import { Component } from '@angular/core';
//
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   title = 'upload-img';
//   imageData: any;
//   file: File;
//
//   getBase64(file) {
//     // tslint:disable-next-line:prefer-const
//     let reader = new FileReader();
//     reader.readAsDataURL(file);
//     reader.onload = () => {
//       console.log(reader.result);
//       this.imageData = reader.result;
//     };
//     reader.onerror =  (error) => {
//       console.log('Error: ', error);
//     };
//   }
//
//   changeFile(event) {
//     const file = event.target.files[0];
//     this.getBase64(file);
//   }
// }

import { Component, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms';

// export class country {
//   id: string;
//   name: string;
//
//   constructor(id: string, name: string) {
//     this.id = id;
//     this.name = name;
//   }
// }

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {

  title = 'FormArray Example in Angular Reactive forms';

  skillsForm: FormGroup;

  constructor(private fb: FormBuilder) {

    this.skillsForm = this.fb.group({
      name: '',
      skills: this.fb.array([]) ,
    });

  }

  get skills(): FormArray {
    return this.skillsForm.get('skills') as FormArray;
  }

  newSkill(): FormGroup {
    return this.fb.group({
      skill: '',
      exp: '',
    });
  }

  addSkills() {
    this.skills.push(this.newSkill());
  }

  removeSkill(i: number) {
    this.skills.removeAt(i);
  }

  onSubmit() {
    console.log(this.skillsForm.value);
  }

  show() {
    console.log('jhsdgfis');
    for (let i = 0; i < this.skills.length; i++) {
      console.log(this.skills.at(i).value);
    }
  }
}
