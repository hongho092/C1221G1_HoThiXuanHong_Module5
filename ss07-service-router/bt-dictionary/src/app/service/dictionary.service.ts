import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionarys: Dictionary[];

  constructor() {
    this.dictionarys = [
      {id: 1, word: 'hello', translate: 'xin chào'},
      {id: 2, word: 'table', translate: 'cái bàn'},
      {id: 3, word: 'phone', translate: 'điện thoại'}
    ];
    // this.dictionarys.push({id: 1, word: 'hello', translate: 'xin chào'});
    // this.dictionarys.push({id: 2, word: 'table', translate: 'cái bàn'});
    // this.dictionarys.push({id: 3, word: 'phone', translate: 'điện thoại'});
  }

  getAll() {
    return this.dictionarys;
  }

  findById(id: number) {
    return this.dictionarys.find(dictionary => dictionary.id === id);
  }

}
