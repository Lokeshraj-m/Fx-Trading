import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookTradeComponent } from './book-trade/book-trade.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { PrintTradeComponent } from './print-trade/print-trade.component';

const routes: Routes = [
  {
    path:"",redirectTo:"/Home",pathMatch:"full"
  },
  {
    path:"Home",component:HomeComponent
  },
  {
    path:"Dashboard",component:DashboardComponent
  },
  {
    path:"BookTrade",component:BookTradeComponent
  },
  {
    path:"PrintTrade",component:PrintTradeComponent
  },
  {
    path:"**",component:NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
