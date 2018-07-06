import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { MatToolbarModule, MatIconModule, MatInputModule, MatCardModule, MatChipsModule } from '@angular/material'
import { FormsModule } from "@angular/forms";
import {FlexLayoutModule} from "@angular/flex-layout";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { PasswordService } from "src/app/password.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatCardModule,
    FormsModule,
    FlexLayoutModule,
    MatChipsModule,
    HttpClientModule
    
  ],
  providers: [ HttpClient,
               PasswordService],
  bootstrap: [AppComponent]
})
export class AppModule { }
