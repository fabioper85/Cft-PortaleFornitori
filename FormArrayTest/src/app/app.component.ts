import { Component, OnInit, AfterContentInit, AfterViewInit, OnChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { FormService } from './form-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Accreditamento fornitore';
  form: FormGroup;
  tipiFornitore: any = null;
  docs = null;
  docsForm: FormGroup;

  constructor(private fb: FormBuilder,
              private formService: FormService) {
    this.createForm();
  }

  ngOnInit() {
    this.loadTipoFornitore();
    this.docsForm = this.fb.group({});
  }

  createForm() {
    this.form = this.fb.group({
      name: [null, Validators.required],
      surname: [null, Validators.required],
      selection: [null, Validators.required]
    });
  }

  loadTipoFornitore() {
    this.formService.getTipologieFornitore()
      .subscribe(data => {
        this.tipiFornitore = data;
      });
  }

  loadDocs(event) {
    this.formService.loadDocs(event.target.value).subscribe(data => {
      this.docs = data;
      this.docsForm = this.fb.group({});
      this.docs.forEach(element => {
        if (element.haScadenza) {
          this.docsForm.addControl((element.codice + 'dataScadenza'), new FormControl(null, null));
          this.docsForm.addControl(element.codice, new FormControl('', Validators.required));
        } else {
          this.docsForm.addControl(element.codice, new FormControl('', Validators.required));
        }
      });
      // console.log(this.docs);
      // console.log(this.docsForm);
    });
  }
}
