import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-print-trade',
  templateUrl: './print-trade.component.html',
  styleUrls: ['./print-trade.component.css']
})
export class PrintTradeComponent implements OnInit {

  TradeList:any[]=[];
  p:number=1

  constructor(private service:HttpService,
    private router:Router) { }

  ngOnInit(): void {
    this.GetTradeList();
  }

  GetTradeList(){
    this.service.getTradeList()
    .subscribe((response:any)=>{
      this.TradeList=response;
    })
  }

  onClick(){
    this.router.navigate(['/Dashboard']);
  }

}
