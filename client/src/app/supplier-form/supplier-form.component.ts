import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-supplier-form',
  templateUrl: './supplier-form.component.html',
  styleUrls: ['./supplier-form.component.css']
})
export class SupplierFormComponent implements OnInit {

  private ragioneSociale: string;
  constructor() {}

  ngOnInit() {
  }
  
  public log(event) {
    console.log(event);
  }
}
