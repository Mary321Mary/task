import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Car{
  constructor(
    public id: number,
    public name: string,
    public model: string,
    public generation: string,
    public mileage: string,
    public engine: string,
    public price: number
  ) {}
}

export class CarCriteria{
  constructor(
    public model: string,
    public generation: string,
    public mileage: string,
    public engine: string,
    public priceFrom: number,
    public priceTo: number,
    public sort: string
  ) {}
}

export class Criterias{
  constructor(
    public cars: Car[],
    public carsModels: string[],
    public carsGenerations: string[],
    public carsMileages: string[],
    public carsEngines: string[]
  ) {}
}

export class User {
  constructor(
    public username: string,
    public role: string
  ) {}
}

export class Role {
  constructor(
    public name: string
  ) {}
}

export class JwtResponse {
  constructor(
	  public accessToken: string,
    public username: string,
    public roles: Role[]
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public login(credentials: any) {
    return this.httpClient.post<JwtResponse>('http://localhost:8080/login', {
      username: credentials.username,
      password: credentials.password
    });
  }

  public getCars() {
    let isDeleted = JSON.parse(localStorage.getItem('admin')!);
    let carCriteria = JSON.parse(localStorage.getItem('CarCriteria')!);
    if(carCriteria == null) {
      carCriteria = new CarCriteria("", "", "", "", 0, 50000, "asc");
    }
    return this.httpClient.post<Criterias>('http://localhost:8080/car/all', {
      isDeleted: isDeleted,
      carCriteria: carCriteria
    });
  }

  public getCar() {
    let idOfCar = JSON.parse(localStorage.getItem('id')!);
    return this.httpClient.get<Car>('http://localhost:8080/car/' + idOfCar);
  }

  public getMyCars() {
    let username = JSON.parse(localStorage.getItem('username')!);
    return this.httpClient.get<Car[]>('http://localhost:8080/car/mycars/' + username);
  }

  public editCar(car: Car) {
    return this.httpClient.post('http://localhost:8080/car/update', car);
  }

  public deleteCar(idOfCar: number) {
    return this.httpClient.delete('http://localhost:8080/car/delete/' + idOfCar);
  }

  public addCar(car: Car) {
    let username = JSON.parse(localStorage.getItem('username')!);
    return this.httpClient.post('http://localhost:8080/car/add', {car, username});
  }

  public getUsers() {
    return this.httpClient.get<User[]>('http://localhost:8080/user');
  }
}
