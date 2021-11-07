import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Car, CarCriteria, Criterias } from '../service/http-client.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  pages: number[] = [];
  page: number = 0;
  criterias!: Criterias;
  car: CarCriteria = new CarCriteria("", "", "", "", 0, 50000, "asc");

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getCars().subscribe(
      response => {
        this.criterias = response,
        this.pages = new Array(response.totalPages);
      },
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

  setPage(i: number){
    localStorage.setItem('page', JSON.stringify(i));
    this.router.navigate(['/products']);
  }
}
