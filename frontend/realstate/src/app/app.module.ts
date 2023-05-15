import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { SliderComponent } from './components/slider/slider.component';
import { HomeComponent } from './pages/home/home.component';
import { NavigationLinkComponent } from './components/navigation-link/navigation-link.component';
import { CustomButtonComponent } from './components/custom-button/custom-button.component';
import { CardComponent } from './components/card/card.component';
import { PropertyComponent } from './components/property/property.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    SliderComponent,
    HomeComponent,
    NavigationLinkComponent,
    CustomButtonComponent,
    CardComponent,
    PropertyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
