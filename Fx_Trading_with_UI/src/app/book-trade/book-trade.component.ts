import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-book-trade',
  templateUrl: './book-trade.component.html',
  styleUrls: ['./book-trade.component.css']
})
export class BookTradeComponent implements OnInit {

  currencyPairs:any[]=['USDINR'];
  exchangeRate:any[]=['Yes','No'];
  isHidden:boolean=true;
  isDisabled:boolean=true;
  Name_Pattern:any='[A-Za-z\\s.]*';

  constructor(private router:Router,
    private service:HttpService,
    private toastr:ToastrService) { }

  ngOnInit(): void {
  }
  onSubmit(f:NgForm){
    this.isHidden=false;
    let obj={
      customerName:f.value.name,
      currencyPair:f.value.currencyPair,
      transferAmount:f.value.amount,
      getRate:f.value.getRate
    }
    this.service.getRate(obj)
    .subscribe((response)=>{
      alert(response);
      this.toastr.info(response,'Rate');
    })
  }

  onBook(){
    this.isDisabled=false;
    this.service.BookTrade('book')
    .subscribe((response)=>{
      alert(response);
      this.toastr.success(response,'Successfull');
      this.router.navigate(['/Dashboard']);
    })   
  }
  onCancel(){
    this.service.BookTrade('cancel')
    .subscribe((response)=>{
      alert(response);
      this.toastr.success(response,'Cancelled');
      this.router.navigate(['/Dashboard']);
    })  
  }

}
