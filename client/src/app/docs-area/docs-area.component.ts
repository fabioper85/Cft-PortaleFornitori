import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-docs-area',
  templateUrl: './docs-area.component.html',
  styleUrls: ['./docs-area.component.css']
})
export class DocsAreaComponent implements OnInit {
  currentOrientation = 'vertical';
  constructor() { }

  ngOnInit() {
  }

}
