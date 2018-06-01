import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public vatNum: string;
  public password: string;
  public firstAttempt = true;
  public isLoggedIn = false;
  public loginErr: any;
  private usersList: Array<any>;


  constructor(private userService: UserService) {}

  ngOnInit() {
  }

  public logUsers() {
    this.userService.getAll().subscribe(data => {
      this.usersList = data;
      console.log(this.usersList);
    });
  }

  public checkLogin() {
    this.firstAttempt = false;
    this.userService.getPasswordPost(this.vatNum, this.password)
      .subscribe(data => {
        if (data) {
          this.isLoggedIn = true;
        } else {
          this.loginErr = true;
        }
      });
  }
}
