import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PasswordService {

  constructor(private _httpClient: HttpClient) { }

  checkPassword(password) {
    var ip = window.location.origin;
    const url = ip + '/api/v1/password/check';
    return this._httpClient.post<any>(url, {"password": password});
  }
}