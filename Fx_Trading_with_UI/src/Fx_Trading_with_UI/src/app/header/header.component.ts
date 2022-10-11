import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router,
    private toastr:ToastrService) { }

  ngOnInit(): void {
  }
  onClick(){
    if(confirm("Do You want to Exit?")){
      this.router.navigate(['/Home']);
      this.toastr.info("Have a Great Day","Thank You")
    }
  }
}
