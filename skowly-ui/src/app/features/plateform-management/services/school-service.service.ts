import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { School } from '../../../core/models/school.model';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {
  private baseUrl = '/api/core/schools'; // Update the API base URL

  constructor(private http: HttpClient) {}

  getAllSchools(): Observable<School[]> {
    return this.http.get<School[]>(this.baseUrl);
  }

  getSchoolById(id: number): Observable<School> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<School>(url);
  }

  createSchool(school: School): Observable<School> {
    return this.http.post<School>(this.baseUrl, school);
  }

  updateSchool(id: number, updatedSchool: School): Observable<School> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<School>(url, updatedSchool);
  }

  deleteSchool(id: number |undefined): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
  
}