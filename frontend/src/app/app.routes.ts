import { Routes } from '@angular/router';
import { Quienessomos } from './quienessomos/quienessomos';
import { Inicio } from './inicio/inicio';
import { Proyectos } from './proyectos/proyectos';
import { Producciones } from './producciones/producciones';
import { Contacto } from './contacto/contacto';
import { Streaming } from './streaming/streaming';

export const routes: Routes = [
    {path:'',component:Inicio},
    {path:'quienes-somos',component:Quienessomos},
    {path:'proyectos',component:Proyectos},
    {path:'producciones',component:Producciones},
    {path:'contacto',component:Contacto},
    {path:'streaming',component:Streaming},
];
