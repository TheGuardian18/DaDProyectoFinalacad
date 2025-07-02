import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {resources} from '../../resources/resources';


@Injectable({providedIn: 'root'})
export class RequisitoService {
  constructor(private http: HttpClient) {
  }

  getRequisitos(): Observable<any[]> {
    return this.http.get<any[]>(resources.requisitos.requisito); // Se agregará la baseUrl por el interceptor
  }



}
