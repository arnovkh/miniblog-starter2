import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable()
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  loginUser(userId: String) {
    console.log("login");
    this.http.post('http://localhost:8083/users/authenticate', {username: userId})
      .subscribe();
  }
  registerUser(userId: String) {
    console.log('Registration');
    this.http.post('http://localhost:8083/users/', {name: userId})
      .subscribe();
  }

}
