import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { AuthService } from '../services/auth.service';

export const adminGuard: CanActivateFn = () => {

  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.comprobarSesion().pipe(

    map((autenticado) => {

      if (autenticado) {
        return true;
      }

      router.navigate(['/login-admin']);
      return false;

    })

  );
};