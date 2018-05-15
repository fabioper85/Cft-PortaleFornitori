import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-supplier-form',
  templateUrl: './supplier-form.component.html',
  styleUrls: ['./supplier-form.component.css']
})
export class SupplierFormComponent implements OnInit {
  
  public ragioneSociale = 'Ciccio';
  public selectedFiles = null;
  
  constructor() {}

  ngOnInit() {
  }
  
  public log(event) {
    console.log(event);
  }
  
  public submit(event) {
    console.log(event.target[0].value);
    this.ragioneSociale = event.target[0].value;
  }
  
  public set(event1, event2) {
    event1.checked = true;
    event2.checked = false;
  }
}
