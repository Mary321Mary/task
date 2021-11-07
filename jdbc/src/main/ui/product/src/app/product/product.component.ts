import { Component, OnInit } from '@angular/core';
import { HttpClientService, Car, CarCriteria, Criterias } from '../service/http-client.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  criterias!: Criterias;
  car: CarCriteria = new CarCriteria("", "", "", "", 0, 50000, "asc");

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getCars().subscribe(
      response => {this.criterias = response},
    );
  }

  description(idOfCar: number): void {
    localStorage.setItem('id', JSON.stringify(idOfCar));
  }

  Submit() {
    localStorage.setItem('CarCriteria', JSON.stringify(this.car));
    //alert(JSON.stringify(this.car));
    location.reload();
  }
}
