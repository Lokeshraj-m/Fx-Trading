import { NumberFormatStyle } from "@angular/common";

export interface TradeList{
    tradeNo:number,
    customerName:string,
    currencyPair:string,
    amount:number,
    rate:number
}