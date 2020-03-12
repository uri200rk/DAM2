import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//rutas
import {APP_ROUTING} from './app.routes';

//servicios

import { HeroesService } from './servicios/heroes.service';

//componentes
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/share/navbar/navbar.component';
import { HomeComponent } from './component/home/home.component';
import { HeroesComponent } from './component/heroes/heroes.component';
import { AboutComponent } from './component/about/about.component';
import { HeroeComponent } from './component/heroe/heroe.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    HeroesComponent,
    AboutComponent,
    HeroeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    APP_ROUTING
  ],
  providers: [
    HeroesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
