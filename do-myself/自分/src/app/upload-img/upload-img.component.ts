import { Component, OnInit } from '@angular/core';
import {FormGroup} from '@angular/forms';
import {finalize, subscribeOn} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/compat/storage';
import {formatDate} from '@angular/common';
// @ts-ignore
import Any = jasmine.Any;

@Component({
  selector: 'app-upload-img',
  templateUrl: './upload-img.component.html',
  styleUrls: ['./upload-img.component.css']
})
export class UploadImgComponent implements OnInit {
  private imgSrc: any;

  constructor(private storage: AngularFireStorage) { }

  selectedImage: any = null;

  ngOnInit(): void {
  }

  showPreview(event: Any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => this.imgSrc = e.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.targat.files[0];
      // this.submit();
    } else {
      this.imgSrc = '';
      this.selectedImage = null;
    }
  }

  // private submit() {
  //   if (this.selectedImage !== null) {
  //     const filePath = `avatar/${this.selectedImage.name.split('.').splice(0, -1).join('.')}_${new Date().getTime()}`;
  //     const fileRef = this.storage.ref(filePath);
  //     this.storage.upload(filePath, this.selectedImage).snapshotChanges().pipe(
  //     ).subscribe();
  //   }
  // }

}

// finalize ( () => {
//   fileRef.getDownloadURL().subscribe(url => {
//     this.imgSrc = url;
//   });
// }),
