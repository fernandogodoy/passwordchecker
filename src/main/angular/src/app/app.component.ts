import { Component } from '@angular/core';
import { PasswordService } from "src/app/password.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  public result:any = {};

  constructor(private _passwordService : PasswordService){
    
  }

  verifyPass(password) {
      this._passwordService.checkPassword(password).subscribe(
        suc => {this.result = suc},
        error => {
          console.log(error);
          this.result = {};
        }
      )
  }

}
