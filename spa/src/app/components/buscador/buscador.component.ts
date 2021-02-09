import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HeroesService } from 'src/app/services/heroes.service';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styles: [
  ]
})
export class BuscadorComponent implements OnInit {

heroes : any[] = [];
termino : string;

  constructor( private activatedRouter : ActivatedRoute,
    private heroesService : HeroesService) {

   }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe( params => {
      this.termino = params['texto'];
      this.heroes = this.heroesService.buscarHeroe(this.termino);
      console.log(this.heroes);
    });
  }

}
