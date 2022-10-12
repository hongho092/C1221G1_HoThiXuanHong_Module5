import { Component, OnInit } from '@angular/core';
import {HopDong} from '../../model/hop-dong';
import {Router} from '@angular/router';
import {HopDongService} from '../../server/hop-dong.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  hopDongs: HopDong[] = [];

  idDelete: number;

  nameDelete: string;

  searchForm: FormGroup;

  listIdDelete: number[] = [];



  constructor(private hopDongService: HopDongService,
              private router: Router) {
    this.searchForm = new FormGroup({
      searchMa: new FormControl(),
      searchLoaiMa: new FormControl(),
      searchAddress: new FormControl(),
      searchDateS: new FormControl(),
      searchDateE: new FormControl(),
      searchKieuNgay: new FormControl(),
      searchSortGia: new FormControl()
    });
  }

  ngOnInit(): void {
    this.hopDongService.getAll().subscribe(hopDongs => {
      this.hopDongs = hopDongs;
    });
  }

  info(id: number, name: string) {
    this.idDelete = id;
    this.nameDelete = name;
  }

  delete(id: number) {
    this.hopDongService.deleteHopDong(id).subscribe(() => {
      this.ngOnInit();
    }, e => console.log(e));
  }

  search() {
    console.log(this.searchForm.value);
    if (this.searchForm.value.searchMa === null) {
      this.searchForm.value.searchMa = '';
    }
    if (this.searchForm.value.searchLoaiMa === null) {
      this.searchForm.value.searchLoaiMa = 'maDat';
    }
    if (this.searchForm.value.searchAddress === null) {
      this.searchForm.value.searchAddress = '';
    }
    if (this.searchForm.value.searchDateS === null) {
      this.searchForm.value.searchDateS = '2000/01/01';
    }
    if (this.searchForm.value.searchDateE === null) {
      this.searchForm.value.searchDateE = '3000/01/01';
    }
    if (this.searchForm.value.searchKieuNgay === null) {
      this.searchForm.value.searchKieuNgay = 'ngayBatDau';
    }
    if (this.searchForm.value.searchSortGia === null) {
      this.searchForm.value.searchSortGia = '';
    }
    console.log(this.searchForm.value);
    // this.hopDongService.searchHopDong(this.searchForm.value.searchMa,
    //                                   this.searchForm.value.searchLoaiMa,
    //                                   this.searchForm.value.searchAddress,
    //                                   this.searchForm.value.searchSortGia,
    //                                   this.searchForm.value.searchDateS,
    //                                   this.searchForm.value.searchDateE,
    //                                   this.searchForm.value.searchKieuNgay).subscribe(
    //   hopDongs => this.hopDongs = hopDongs);
  }

  addIdToDeleteList(id: number) {
    let flag = false;
    // sử dụng để loại id ra khỏi mảng nếu id đã được checkbox
    for (const idd of this.listIdDelete) {
      if (id === idd) {
        this.listIdDelete = this.listIdDelete.filter(thisId => {
          flag = true;
          return thisId !== id;
        });
      }
    }
    // sử dụng để thêm id vào trong mảng nếu id chưa được checkbox
    if (!flag) {
      this.listIdDelete.push(id);
    }
  }

  countDel = 0;

  color: string = 'white';

  deleteMul() {
    for (let id of this.listIdDelete) {
      this.hopDongService.deleteHopDong(id).subscribe(() => {
        this.countDel++;
      }, error => {
        }, () => {
        if (this.countDel === this.listIdDelete.length) {
          this.ngOnInit();
        }
      });
    }
  }

  p: number = 1;
  m: number = 3;

  hightlight(i: number) {

    i = (this.m * (this.p - 1)) + i;
    this.hopDongs[i].complete = !this.hopDongs[i].complete;
    // console.log('id của đối tượng' + id);
    console.log('i của index' + i);
    console.log('số trang' + this.p);
    // if (this.color === 'yellow') {
    //   this.color = 'white';
    // } else {
    //   this.color = 'yellow';
    // }
  }
}
