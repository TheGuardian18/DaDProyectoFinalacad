import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SedeService } from './core/service/Sede/sede.service';
import { UgelService } from './core/service/Ugel/ugel.service';
import {InstitucionService} from './core/service/institucion/institucion.service';



@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    RouterOutlet
  ],
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'acad-yunior';

  constructor(
    private sedeService: SedeService,
    private institucionservice: InstitucionService,
    private ugelService: UgelService
  ) {

    this.institucionservice.getAll$().subscribe(response => {
      console.log(response);
    });


    this.sedeService.getSedes().subscribe(response => {
      console.log(response);
    });

    this.ugelService.getAll$().subscribe(response => {
      console.log(response);
    });
  }
}
