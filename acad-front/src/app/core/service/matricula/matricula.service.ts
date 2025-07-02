import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {resources} from '../../resources/resources';


@Injectable({providedIn: 'root'})
export class MatriculaService {
  constructor(private http: HttpClient) {
  }

  getMatriculas(): Observable<any[]> {
    return this.http.get<any[]>(resources.matriculas.matricula); // Se agregará la baseUrl por el interceptor
  }



}
