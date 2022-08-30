import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RentType} from '../model/rent-type';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Facility[]> {
    return this.http.get<Facility[]>(API_URL + '/facilities');
  }

  findById(id: number): Observable<Facility> {
    return this.http.get<Facility>(`${API_URL}/facilities/${id}`);
  }

  saveFacility(facility): Observable<Facility> {
    return this.http.post<Facility>(API_URL + '/facilities', facility);
  }

  editFacility(id: number, facility: Facility): Observable<Facility> {
    return this.http.put<Facility>(`${API_URL}/facilities/${id}`, facility);
  }

  deleteFacility(id: number): Observable<Facility> {
    return this.http.delete<Facility>(`${API_URL}/facilities/${id}`);
  }

  getAllRentType(): Observable<RentType[]> {
    return this.http.get<RentType[]>(API_URL + '/rentTypes');
  }
}
