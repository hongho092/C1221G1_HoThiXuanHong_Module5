import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {DiaDiem} from '../../model/dia-diem';
import {PhuongTienService} from '../../service/phuong-tien.service';
import {DiaDiemService} from '../../service/dia-diem.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  createForm: FormGroup;

  diaDiems: DiaDiem[];

  constructor(private phuongTienService: PhuongTienService,
              private diaDiemService: DiaDiemService,
              private router: Router) {
    this.createForm = new FormGroup({
      // id: new FormControl(),
      bienSoXe: new FormControl('3463'),
      loaiXe: new FormControl('Giường nằm'),
      tenNhaXe: new FormControl('Hong'),
      diemDi: new FormControl(),
      diemDen: new FormControl(),
      soDienThoai: new FormControl('0908767876', [Validators.pattern('^(090|097|093)[0-9]{7}$')]),
      email: new FormControl('kdjfg@gmail.com', [Validators.email]),
      gioDi: new FormControl('05:00', [this.validateCustomHour]),
      gioDen: new FormControl('06:00', [this.validateCustomHour])
    }, Validators.required);
  }

  validateCustomHour(gioDi: AbstractControl) {
    const value1 = String(gioDi.value);
    const value2 = Number(value1.slice(0, 2));
    console.log(value1);
    console.log(value2);
    if (value2 < 5 || value2 > 23) {
      return {invalid: true};
    } else {
      return null;
    }
  }

  ngOnInit(): void {
    this.diaDiemService.getAll().subscribe(diaDiems => {
      this.diaDiems = diaDiems;
    });
  }

  create() {
    if (this.createForm.valid) {
      const phuongTien = this.createForm.value;
      this.phuongTienService.savePhuongTien(phuongTien).subscribe(() => {
        alert('Tạo thành công');
        this.createForm.reset();
        this.router.navigateByUrl('');
      }, e => console.log(e));
    }
  }

}
