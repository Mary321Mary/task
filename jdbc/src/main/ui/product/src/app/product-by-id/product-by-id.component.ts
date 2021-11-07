import { Component, OnInit } from '@angular/core';
import { HttpClientService, Car } from '../service/http-client.service';

@Component({
  selector: 'app-product-by-id',
  templateUrl: './product-by-id.component.html',
  styleUrls: ['./product-by-id.component.css']
})
export class ProductByIdComponent implements OnInit {

  car: Car = new Car(-1, "", "", "", "", "", -1);

  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getCar().subscribe(
      response => {this.car = response},
    );
  }

}
