import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }

  BookTrade(confirmation:string){
    return this.http.post(`${environment.baseUrl}exchangeRate/${confirmation}`,null,{
      responseType:"text"
    });
  }
  getRate(obj:any){
    return this.http.post(`${environment.baseUrl}exchangeRate`,obj,{
      responseType:"text"
    })
  }
  getTradeList(){
    return this.http.get(`${environment.baseUrl}printTrade`)
  }
}
