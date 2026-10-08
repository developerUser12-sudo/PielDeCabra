import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Documental {
    id?: number;
    titulo: string;
    sinopsis: string;
    anoProduccion: number;
    duracion: number;
    cartel: string;
    iframe: string;
}

@Injectable({
    providedIn: 'root'
})
export class DocumentalService {

    constructor(private http: HttpClient) { }
    crearDocumental(documental: Documental): Observable<Documental> {
        return this.http.post<Documental>(
            '/api/admin/documentales',documental,
            {
                withCredentials: true
            }
        );
    }

    
}