import { User } from '../models/user';
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
  public datiLogin;
  public loggedIn = false;
  private usersList: Array<any>;
  private user: User;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = new User();
  }

  public logUsers() {
    this.userService.getAll().subscribe(data => {
      this.usersList = data;
      console.log(this.usersList);
    });
  }
  
  public checkLogin() {
    this.user.vatNum = this.vatNum;
    this.user.password = this.password;
    this.userService.getPassword(this.vatNum, this.password).subscribe(
      data => console.log(data));
  }
}
