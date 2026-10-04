import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginadmin',
  imports: [FormsModule],
  templateUrl: './loginadmin.html',
  styleUrl: './loginadmin.scss',
})
export class Loginadmin {
  email = '';
  contrasena = '';
  constructor(private authService: AuthService, private router: Router) {

  }
  iniciarSesion() {
    this.authService.login(this.email, this.contrasena).subscribe({
      next: (respuesta) => {
        this.router.navigate(['/panel-admin']);
      },
      error: (error) => {
        alert("Credenciales incorrectas");
      }
    });

  }
}
