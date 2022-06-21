import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {DiaDiemService} from '../../service/dia-diem.service';
import {PhuongTienService} from '../../service/phuong-tien.service';
import {DiaDiem} from '../../model/dia-diem';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  editForm: FormGroup;

  id: number;

  diaDiems: DiaDiem[];

  equals(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(private phuongTienService: PhuongTienService,
              private diaDiemService: DiaDiemService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      phuongTienService.findById(this.id).subscribe(phuongTien => {
        this.editForm = new FormGroup({
          id: new FormControl(phuongTien.id),
          bienSoXe: new FormControl(phuongTien.bienSoXe),
          loaiXe: new FormControl(phuongTien.loaiXe, ),
          tenNhaXe: new FormControl(phuongTien.tenNhaXe),
          diemDi: new FormControl(phuongTien.diemDi),
          diemDen: new FormControl(phuongTien.diemDen),
          soDienThoai: new FormControl(phuongTien.soDienThoai, [Validators.pattern('^(090|097|093)[0-9]{7}$')]),
          email: new FormControl(phuongTien.email, [Validators.email]),
          gioDi: new FormControl(phuongTien.gioDi, [this.validateCustomHour]),
          gioDen: new FormControl(phuongTien.gioDen, [this.validateCustomHour])
        }, Validators.required);
      });
    });
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

  editPhuongTien(id: number) {
    if (this.editForm.valid) {
      const phuongTien = this.editForm.value;
      this.phuongTienService.editPhuongTien(id, phuongTien).subscribe(() => {
        alert('Cập nhật thành công');
        this.router.navigateByUrl('');
      });
    }
  }

}
// ^[0-1]{9}|[2]{1,4}):[0-6]{1}[0-9]{1}$
