import {Injectable} from '@angular/core';
import {Contract} from '../model/contract';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Contract[]> {
    return this.http.get<Contract[]>(API_URL + '/contracts');
  }

  saveContract(contract): Observable<Contract> {
    return this.http.post<Contract>(API_URL + '/contracts', contract);
  }

  // getAll() {
  //   return this.contracts;
  // }
  //
  // saveContract(contract: Contract) {
  //   this.contracts.push(contract);
  // }
}
