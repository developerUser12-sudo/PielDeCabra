import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-loginadmin',
  imports: [FormsModule],
  templateUrl: './loginadmin.html',
  styleUrl: './loginadmin.scss',
})
export class Loginadmin {
  email='';
  contrasena='';
  iniciarSesion(){
    console.log(this.email,this.contrasena);
    
  }
}
