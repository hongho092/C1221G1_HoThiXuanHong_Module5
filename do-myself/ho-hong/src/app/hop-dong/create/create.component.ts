import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../../server/category.service';
import {Router} from '@angular/router';
import {Category} from '../../model/category';
import {HopDongService} from '../../server/hop-dong.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  categories: Category[];

  createForm: FormGroup;

  constructor(private hopDongService: HopDongService,
              private categoryService: CategoryService,
              private router: Router) {
    this.createForm = new FormGroup({
      maDat: new FormControl(),
      maNguoiBan: new FormControl(),
      ngayBatDau: new FormControl(),
      ngayKetThuc: new FormControl(),
      diaChi: new FormControl(),
      gia: new FormControl(),
      category: new FormControl(),
    }, Validators.required);
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }

  create() {
    if (this.createForm.valid) {
      const hopDong = this.createForm.value;
      this.hopDongService.saveHopDong(hopDong).subscribe(() => {
        alert('Tạo thành công');
        this.createForm.reset();
        this.router.navigateByUrl('');
      }, e => console.log(e));
    }
  }

}
