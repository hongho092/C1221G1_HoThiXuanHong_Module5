import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Dictionary} from '../../model/dictionary';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  detailWord: Dictionary;

  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      if (id != null) {
        this.detailWord = dictionaryService.findById(Number(id));
        console.log(this.detailWord);
      }
    });
  }

  ngOnInit(): void {
  }

}
