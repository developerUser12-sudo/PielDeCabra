import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  comprobarSesion(): Observable<boolean> {
    return this.http.get<boolean>(
      '/api/auth/comprobar-sesion',
      {
        withCredentials: true
      }
    );
  }

  login(email: string, contrasena: string): Observable<any> {
    return this.http.post(
      '/api/auth/login',
      {
        email,
        contrasena
      },
      {
        withCredentials: true
      }
    );
  }
}