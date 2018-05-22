import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';

@Component({
  selector: 'app-supp-form',
  templateUrl: './supplier-form.component.html',
  styleUrls: ['./supplier-form.component.css']
})
export class SupplierFormComponent {

  supplierForm: FormGroup;
  docs: Array<Document>;

  constructor(private fb: FormBuilder) {
    this.createBg(); // <--- inject FormBuilder
    this.createForm();
  }

  createForm() {
    this.supplierForm = this.fb.group({

      ragioneSociale: ['', Validators.required],

      sedeLegale: ['', Validators.required],

      sedeOperativa: ['', Validators.required],

      dataInizioAttività: ['', Validators.required],

      partitaIVA: ['', Validators.required],

      codiceFiscale: ['', Validators.required],

      telNumero: ['', Validators.required],

      faxNumero: ['', Validators.required],

      email: ['', [Validators.required, Validators.email]],

      tipoFornitore: ['PIVA', Validators.required],

      partitaIVADocs: this.fb.group({
        questionario: [null, Validators.required],
        docIdentità: [null , Validators.required],
        curriculum: [null, Validators.required],
        foto: [null, Validators.required],
        visuraCamerale: [null, Validators.required]

      }),

      /*
      societàDocs: this.fb.group({

        durc: [null, Validators.required],
        uni9001: [null, Validators.required]

      })
      */
    });
  }

  createBg() {
    document.body.style.backgroundImage = 'url("../../assets/images/building02.jpg")';
    document.body.style.backgroundColor = '#333';
    document.body.style.backgroundPosition = 'center center';
    document.body.style.backgroundRepeat = 'no-repeat';
    document.body.style.backgroundAttachment = 'fixed';
    document.body.style.backgroundSize = 'cover';
  }

  log() {
    console.log(this.supplierForm);
  }
}
