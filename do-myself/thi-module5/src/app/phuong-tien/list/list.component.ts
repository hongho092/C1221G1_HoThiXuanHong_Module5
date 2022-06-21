import { Component, OnInit } from '@angular/core';
import {PhuongTien} from '../../model/phuong-tien';
import {PhuongTienService} from '../../service/phuong-tien.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  phuongTiens: PhuongTien[] = [];

  idDelete: number;

  nameDelete: string;

  p = 0;

  searchForm: FormGroup;

  constructor(private phuongTienService: PhuongTienService) {
    this.searchForm = new FormGroup({
      search: new FormControl()
    });
  }

  ngOnInit(): void {
    this.phuongTienService.getAll().subscribe(phuongTiens => {
      this.phuongTiens = phuongTiens;
      // console.log(this.phuongTiens.content);
    });
  }

  info(id: number, name: string) {
    this.idDelete = id;
    this.nameDelete = name;
  }

  delete(id: number) {
    this.phuongTienService.deletePhuongTien(id).subscribe(() => {
      this.ngOnInit();
    }, e => console.log(e));
  }

  search() {
    console.log(this.searchForm.value.search);
    this.phuongTienService.searchPhuongTien(this.searchForm.value.search).subscribe(phuongTiens => {
      this.phuongTiens = phuongTiens;
    });
  }
}
