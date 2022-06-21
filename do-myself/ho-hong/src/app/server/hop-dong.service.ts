import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HopDong} from '../model/hop-dong';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class HopDongService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<HopDong[]> {
    return this.http.get<HopDong[]>(API_URL + '/hopDongs');
  }

  saveHopDong(hopDong): Observable<HopDong> {
    return this.http.post<HopDong>(API_URL + '/hopDongs', hopDong);
  }

  findById(id: number): Observable<HopDong> {
    return this.http.get<HopDong>(`${API_URL}/hopDongs/${id}`);
  }

  editHopDong(id: number, hopDong: HopDong): Observable<HopDong> {
    return this.http.put<HopDong>(`${API_URL}/hopDongs/${id}`, hopDong);
  }

  deleteHopDong(id: number): Observable<HopDong> {
    return this.http.delete<HopDong>(`${API_URL}/hopDongs/${id}`);
  }

  searchHopDong(searchMa: string,
                searchLoaiMa: string,
                searchAddress: string,
                searchSortGia: string,
                searchDateS: string,
                searchDateE: string,
                searchKieuNgay: string): Observable<HopDong[]> {
    return this.http.get<HopDong[]>(`${API_URL}/hopDongs?${searchLoaiMa}_like=${searchMa}&diaChi_like=${searchAddress}&_sort=gia&_order=${searchSortGia}&${searchKieuNgay}_gte=${searchDateS}&${searchKieuNgay}_lte=${searchDateE}`);
  }
}
