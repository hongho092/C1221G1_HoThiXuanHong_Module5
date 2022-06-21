import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {HopDongService} from '../../server/hop-dong.service';
import {CategoryService} from '../../server/category.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  editForm: FormGroup;

  id: number;

  categories: Category[];

  equals(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(private hopDongService: HopDongService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      hopDongService.findById(this.id).subscribe(hopDong => {
        this.editForm = new FormGroup({
          maDat: new FormControl(hopDong.maDat),
          maNguoiBan: new FormControl(hopDong.maNguoiBan),
          ngayBatDau: new FormControl(hopDong.ngayBatDau),
          ngayKetThuc: new FormControl(hopDong.ngayKetThuc),
          diaChi: new FormControl(hopDong.diaChi),
          gia: new FormControl(hopDong.gia),
          category: new FormControl(hopDong.category),
        }, Validators.required);
      });
    });
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }

  editHopDong(id: number) {
    const hopDong = this.editForm.value;
    this.hopDongService.editHopDong(id, hopDong).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('');
    });
  }

}
