import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Car } from '../service/http-client.service';

@Component({
  selector: 'app-mycars',
  templateUrl: './mycars.component.html',
  styleUrls: ['./mycars.component.css']
})
export class MycarsComponent implements OnInit {

  cars: Car[] = [];

  constructor(
    private httpClientService: HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getMyCars().subscribe(
      response => {this.cars = response},
    );
  }

  edit(idOfCar: number): void {
    localStorage.setItem('id', JSON.stringify(idOfCar));
  }

  Delete(idOfCar: number): void {
    this.httpClientService.deleteCar(idOfCar).subscribe();
    this.router.navigate(['/mycars']);
  }

  description(idOfCar: number): void {
    localStorage.setItem('id', JSON.stringify(idOfCar));
  }
}
