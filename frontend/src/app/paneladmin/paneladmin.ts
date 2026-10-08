import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { DocumentalService } from '../services/documental.service';

@Component({
  selector: 'app-paneladmin',
  imports: [FormsModule],
  templateUrl: './paneladmin.html',
  styleUrl: './paneladmin.scss',
})
export class Paneladmin {
  titulo = '';
  sinopsis = '';
  anoProduccion = 0;
  duracion = 0;
  cartel = '';
  iframe = '';
  constructor(private documentalService: DocumentalService) { }
  crearDocumental() {
    const documental = {
      titulo: this.titulo,
      sinopsis: this.sinopsis,
      anoProduccion: this.anoProduccion,
      duracion: this.duracion,
      cartel: this.cartel,
      iframe: this.iframe
    };
    this.documentalService.crearDocumental(documental).subscribe({
      next:(respuesta)=>{
        alert('Documental creado correctamente');
      },
      error:(error)=>{
        alert('No se ha podido crear el documental');
      }
    });
  }
}
