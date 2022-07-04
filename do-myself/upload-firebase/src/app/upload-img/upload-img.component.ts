import {Component, Inject, OnInit} from '@angular/core';
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-upload-img',
  templateUrl: './upload-img.component.html',
  styleUrls: ['./upload-img.component.css']
})
export class UploadImgComponent implements OnInit {

  fileName: File;

  url: string;

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage) { }

  ngOnInit(): void {
  }

  changeFile(event: any) {
    this.fileName = event.target.files[0];
  }

  save() {
    const name = this.getCurrentDateTime() + this.fileName.name;
    const fileRef = this.storage.ref(name);
    this.storage.upload(name, this.fileName).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.url = url;
          console.log(this.url);
          alert('Upload Successful');
        });
      })
    ).subscribe();
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  // update(todo: Todo) {
  //   this.todoCollectionRef.doc(todo.id).update({ completed: !todo.completed });
  // }

  // delete(todo: Todo) {
  //   this.todoCollectionRef.doc(todo.id).delete();
  // }

}
