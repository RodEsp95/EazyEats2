import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ModalLoginComponent } from './modal-login/modal-login.component';
import { AppRoutingModule } from './/app-routing.module';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { CarouselComponent } from './carousel/carousel.component';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { VerifiedrequestComponent } from './verifiedrequest/verifiedrequest.component';
import { RestaurantService } from './Services/restaurant.service';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { CityService } from './Services/city.service';
import { LoginService } from './Services/login.service';
import { RegisterService } from './Services/register.service';
import { FormsModule } from '@angular/forms';
import { RestaurantDirective } from './restaurant.directive';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    ModalLoginComponent,
    RegisterComponent,
    NavbarComponent,
    ProfileComponent,
    CarouselComponent,
    VerifiedrequestComponent,
    RestaurantComponent,
    RestaurantDirective,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    NgbCarouselConfig,
    HttpClient,
    RestaurantService,
    CityService,
    LoginService,
    RegisterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
