import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./category/dashboard/dashboard.component').then((m) => m.DashboardComponent),
    children: [
      // Institución
      {
        path: 'institucion',
        loadComponent: () =>
          import('./category/Institucion/institucion').then(m => m.InstitucionComponent),
      },
      {
        path: 'institucion/editar/:id',
        loadComponent: () =>
          import('./category/Institucion/edit/edit-institucion.componet')
            .then((m) => m.EditInstitucionComponent),
      },
      {
        path: 'institucion/nuevo',
        loadComponent: () =>
          import('./category/Institucion/new/new-institucion.component')
            .then(m => m.NewInstitucionComponent),
      },

      // Sede
      {
        path: 'sedes',
        loadComponent: () =>
          import('./category/Sede/sede').then((m) => m.Sede),
      },
      {
        path: 'sedes/editar/:id',
        loadComponent: () =>
          import('./category/Sede/edit/edit-sede.component')
            .then((m) => m.EditSedeComponent),
      },
      {
        path: 'sedes/nuevo',
        loadComponent: () =>
          import('./category/Sede/new/new-sede.component')
            .then(m => m.NewSedeComponent),
      },

      // UGEL
      {
        path: 'ugeles',
        loadComponent: () =>
          import('./category/Ugel/ugel').then((m) => m.Ugel),
      },
      {
        path: 'ugeles/editar/:id',
        loadComponent: () =>
          import('./category/Ugel/edit/edit-ugel.component')
            .then((m) => m.EditUgelComponent),
      },
      {
        path: 'ugeles/nuevo',
        loadComponent: () =>
          import('./category/Ugel/new/new-ugel.component')
            .then(m => m.NewUgelComponent),
      },

      // Ruta por defecto
      {
        path: '',
        redirectTo: 'ugeles',
        pathMatch: 'full',
      }
    ]
  }
];
