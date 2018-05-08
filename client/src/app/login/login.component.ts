import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private usersList: Array<any>;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public logUsers() {
    this.userService.getAll().subscribe(data => {
      this.usersList = data;
      console.log(this.usersList);
    });
  }
}
