import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {PhuongTien} from '../model/phuong-tien';

const API_URL = `${environment.apiUrl}`;
const API_URL1 = `${environment.apiUrl1}`;

@Injectable({
  providedIn: 'root'
})
export class PhuongTienService {

  constructor(private http: HttpClient) {
  }

  // getAll(): Observable<PhuongTien[]> {
  //   return this.http.get<PhuongTien[]>(API_URL + '/PhuongTiens');
  // }

  getAll(): Observable<PhuongTien[]> {
    return this.http.get<PhuongTien[]>(API_URL1 + '/list');
  }

  savePhuongTien(phuongTien): Observable<PhuongTien> {
    return this.http.post<PhuongTien>(API_URL1 + '/create', phuongTien);
  }

  // findById(id: number): Observable<PhuongTien> {
  //   return this.http.get<PhuongTien>(`${API_URL}/PhuongTiens/${id}`);
  // }

  findById(id: number): Observable<PhuongTien> {
    return this.http.get<PhuongTien>(`${API_URL1}/findById?id=${id}`);
  }

  // editPhuongTien(id: number, phuongTien: PhuongTien): Observable<PhuongTien> {
  //   return this.http.put<PhuongTien>(`${API_URL}/PhuongTiens/${id}`, phuongTien);
  // }

  editPhuongTien(id: number, phuongTien: PhuongTien): Observable<PhuongTien> {
    return this.http.patch<PhuongTien>(`${API_URL1}/edit`, phuongTien);
  }

  // deletePhuongTien(id: number): Observable<PhuongTien> {
  //   return this.http.delete<PhuongTien>(`${API_URL}/PhuongTiens/${id}`);
  // }

  deletePhuongTien(id: number): Observable<PhuongTien> {
    return this.http.delete<PhuongTien>(`${API_URL1}/delete?id=${id}`);
  }

  searchPhuongTien(search: string): Observable<PhuongTien[]> {
    return this.http.get<PhuongTien[]>(`${API_URL1}/search?search=${search}`);
  }
}
