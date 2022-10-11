import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router:Router,
    private toastr:ToastrService,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle("Dashboard-Fx Trading")
  }
  onClick(){
    if(confirm("Do You want to Exit?")){
      this.router.navigate(['/Home']);
      this.toastr.info("Have a Great Day","Thank You")
    }
  }
  onBookTrade(){
    this.router.navigate(['/BookTrade']);
  }
  onTradeList(){
    this.router.navigate(['/PrintTrade']);
  }
}
