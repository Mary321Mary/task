import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Car } from '../service/http-client.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  car: Car = new Car(-1, "", "", "", "", "", 0);

  constructor(
    private httpClientService:HttpClientService, private router: Router
  ) { }

  ngOnInit(): void {
    this.httpClientService.getCar().subscribe(
      response => {this.car = response},
    );
  }

  Submit() {
    localStorage.setItem('Car', JSON.stringify(this.car));
    if(this.car.id != -1){
      this.httpClientService.editCar(this.car).subscribe(
        data => {
          location.reload();
        }
      );
    } else {
      this.httpClientService.addCar(this.car).subscribe();
    }
    this.router.navigate(['/mycars']);
  }

}
