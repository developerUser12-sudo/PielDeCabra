import { Routes } from '@angular/router';
import { Quienessomos } from './quienessomos/quienessomos';
import { Inicio } from './inicio/inicio';
import { Proyectos } from './proyectos/proyectos';
import { Producciones } from './producciones/producciones';
import { Contacto } from './contacto/contacto';
import { Streaming } from './streaming/streaming';
import { Politicaprivacidad } from './politicaprivacidad/politicaprivacidad';
import { Politicacookies } from './politicacookies/politicacookies';
import { Avisolegal } from './avisolegal/avisolegal';

export const routes: Routes = [
    {path:'',component:Inicio},
    {path:'quienes-somos',component:Quienessomos},
    {path:'proyectos',component:Proyectos},
    {path:'producciones',component:Producciones},
    {path:'contacto',component:Contacto},
    {path:'streaming',component:Streaming},
    {path:'politica-privacidad',component:Politicaprivacidad},
    {path:'politica-cookies',component:Politicacookies},
    {path:'aviso-legal',component:Avisolegal},
];
