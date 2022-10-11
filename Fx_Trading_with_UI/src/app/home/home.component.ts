import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router,
    private title:Title) { }

  ngOnInit(): void {
    this.title.setTitle("Home-Fx Trading")
  }
  onClick(){
    this.router.navigate(['/Dashboard'])
  }
}
