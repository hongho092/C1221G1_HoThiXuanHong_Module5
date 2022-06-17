import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
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

  // getAll() {
  //   return this.facilitys;
  // }
  //
  // saveFacility(facility: Facility) {
  //   this.facilitys.push(facility);
  // }
  //
  // findById(id: number) {
  //   return this.facilitys.find(facility => facility.id === id);
  // }
  //
  // editFacility(id: number, facility: Facility) {
  //   for (let i = 0; i < this.facilitys.length; i++) {
  //     if (this.facilitys[i].id === id) {
  //       this.facilitys[i] = facility;
  //     }
  //   }
  // }
}
