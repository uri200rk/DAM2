import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//rutas
import {APP_ROUTING} from './app.routes';

//servicios



//componentes
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/share/navbar/navbar.component';
import { HomeComponent } from './component/home/home.component';
import { HeroesComponent } from './component/heroes/heroes.component';
import { AboutComponent } from './component/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    HeroesComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    APP_ROUTING
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
