import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[] = [];
  isLoggedIn = false;
  admin = false;
  username: string = "Guest";

  constructor(private router: Router) { 

  }

  ngOnInit(): void {
    this.isLoggedIn = !!localStorage.getItem('token');
    if (this.isLoggedIn) {
      let user = JSON.parse(localStorage.getItem('user')!);
      //alert(user.roles);
      this.roles = user.roles;
      this.admin = this.roles.includes('admin');
      localStorage.setItem('admin', JSON.stringify(this.admin));
      this.username = user.username;
    }
  }

  mycars(): void {
    localStorage.setItem('username', JSON.stringify(this.username));
  }

  GoToProducts(): void {
    this.router.navigate(['/products']);
  }

  logout(): void {
    localStorage.clear();
  }
}
