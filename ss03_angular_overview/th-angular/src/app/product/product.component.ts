import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  color: string = 'white';

  highlight() {
    if (this.color === 'yellow') {
      this.color = 'white';
    } else {
      this.color = 'yellow';
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }


//   var chk = document.querySelectorAll("table input[type=checkbox]");
//
//   for (let i = 0; i < chk.length; i++) {
//   chk[i].addEventListener("change", function() {
//     selectRow(this);
//   });
// }

  //
  // selectRow(elem: boolean) {
  //   if (elem === true) {
  //     elem.parentNode.parentNode.style.backgroundColor = 'yellow';
  //   } else {
  //     elem.parentNode.parentNode.style.backgroundColor = '';
  //   }
  // }
  selectRow() {

  }
}

