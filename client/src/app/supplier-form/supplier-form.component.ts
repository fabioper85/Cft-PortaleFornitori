import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-supp-form',
  templateUrl: './supplier-form.component.html',
  styleUrls: ['./supplier-form.component.css']
})
export class SupplierFormComponent implements OnInit {

  supplierForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.createBg(); // <--- inject FormBuilder
    this.createForm();
  }

  ngOnInit() {
    this.supplierForm.controls['societàDocs'].disable();
  }

  submit(event) {
    console.log(event);
    this.http.post('http://localhost:8080/fornitoriTemp', this.createFormData(event))
      .subscribe(data => console.log(data));
    /*
    console.log(this.formData.getAll('docs[]'));
    console.log(this.formData.get('dataInizioAttività'));
    this.addDataToFormData();
    */
  }

  createFormData(event) {
    const datiFornitore = new FormData();
    datiFornitore.append('ragioneSociale', event.target[0].value);
    datiFornitore.append('sedeOperativa', event.target[1].value);
    datiFornitore.append('sedeLegale', event.target[2].value);
    datiFornitore.append('dataInizioAttività', event.target[3].valueAsDate);
    datiFornitore.append('partitaIVA', event.target[4].value);
    datiFornitore.append('codiceFiscale', event.target[5].value);
    datiFornitore.append('telNumero', event.target[6].value);
    datiFornitore.append('faxNumero', event.target[7].value);
    datiFornitore.append('email', event.target[8].value);

    if (this.supplierForm.controls['tipoFornitore'].value === 'PIVA') {
      for (let index = 11; index < 16; index++) {
        datiFornitore.append('docs[]', event.target[index].files[0], (<File>event.target[index].files[0]).name);
      }
    }

    if (this.supplierForm.controls['tipoFornitore'].value === 'SOC') {
      for (let index = 11; index < 17; index++) {
        datiFornitore.append('docs[]', event.target[index].files[0], (<File>event.target[index].files[0]).name);
      }
    }

    return datiFornitore;
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

      partitaIvaDocs: this.fb.group({
        questionario: [null, Validators.required],
        docIdentità: [null , Validators.required],
        curriculum: [null, Validators.required],
        foto: [null, Validators.required],
        visuraCamerale: [null, Validators.required]
      }),

      societàDocs: this.fb.group({
        questionario: [null, Validators.required],
        visuraCamerale: [null, Validators.required],
        iso9001: [null, Validators.required],
        polizzaRctRco: [null, Validators.required],
        durc: [null, Validators.required],
        bilancio: [null, Validators.required]
      })
    });
  }

  createBg() {
    document.body.style.backgroundImage = 'url("../../assets/images/building02.jpg")';
    document.body.style.backgroundColor = '#222';
    document.body.style.backgroundPosition = 'center center';
    document.body.style.backgroundRepeat = 'no-repeat';
    document.body.style.backgroundAttachment = 'fixed';
    document.body.style.backgroundSize = 'cover';
  }

  activate(tipoFornitore: string) {
    switch (tipoFornitore) {
      case 'PIVA':
        this.supplierForm.get('societàDocs').disable();
        this.supplierForm.get('partitaIvaDocs').enable();
        break;
      case 'SOC':
        this.supplierForm.get('partitaIvaDocs').disable();
        this.supplierForm.get('societàDocs').enable();
        break;
    }
  }

  /*
  onFileChange(event) {
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      this.files.push(file);
      console.log(this.files);
      console.log(event);
    }
  }
  */

  /*
  addDataToFormData(files: File[]) {
    const datiFornitore = new FormData();
    datiFornitore.append('ragioneSociale', this.supplierForm.get('ragioneSociale').value);
    datiFornitore.append('sedeOperativa', this.supplierForm.get('sedeOperativa').value);
    datiFornitore.append('sedeLegale', this.supplierForm.get('sedeLegale').value);
    datiFornitore.append('dataInizioAttività', this.supplierForm.get('dataInizioAttività').value);
    datiFornitore.append('partitaIVA', this.supplierForm.get('partitaIVA').value);
    datiFornitore.append('codiceFiscale', this.supplierForm.get('codiceFiscale').value);
    datiFornitore.append('telNumero', this.supplierForm.get('telNumero').value);
    datiFornitore.append('faxNumero', this.supplierForm.get('faxNumero').value);
    datiFornitore.append('email', this.supplierForm.get('email').value);

    if ( this.supplierForm.get('tipoFornitore').value === 'PIVA') {
      datiFornitore.append('questionario', this.supplierForm.controls['partitaIvaDocs'].get('questionario').value);
      datiFornitore.append('docIdentità', file, this.supplierForm.controls['partitaIvaDocs'].get('docIdentità').value);
      datiFornitore.append('curriculum', this.supplierForm.controls['partitaIvaDocs'].get('curriculum').value);
      datiFornitore.append('foto', this.supplierForm.controls['partitaIvaDocs'].get('foto').value);
      datiFornitore.append('visuraCamerale', this.supplierForm.controls['partitaIvaDocs'].get('visuraCamerale').value);
    }

    if ( this.supplierForm.get('tipoFornitore').value === 'SOC') {
      datiFornitore.append('questionario', this.supplierForm.controls['partitaIvaDocs'].get('questionario').value);
      datiFornitore.append('visuraCamerale', this.supplierForm.controls['partitaIvaDocs'].get('visuraCamerale').value);
      datiFornitore.append('iso9001', this.supplierForm.controls['partitaIvaDocs'].get('iso9001').value);
      datiFornitore.append('polizzaRctRco', this.supplierForm.controls['partitaIvaDocs'].get('polizzaRctRco').value);
      datiFornitore.append('durc', this.supplierForm.controls['partitaIvaDocs'].get('durc').value);
      datiFornitore.append('bilancio', this.supplierForm.controls['partitaIvaDocs'].get('bilancio').value);
    }
    console.log(this.supplierForm.controls);
    /*
    const tf = this.supplierForm.controls['tipoFornitore'].value;
    switch (tf) {
      this.datiFornitore.append('')
    }
  }
    */

  /*

  log(valoreCampo) {
    this.http.get('http://localhost:8080/fornitori').subscribe(data => console.log(data));
    this.addDocs(valoreCampo);
    console.log(valoreCampo);
    console.log(this.supplierForm.controls);
  }

  addDocs (tipoFornitore: string) {
  switch (tipoFornitore) {
    case 'PIVA':
      const partitaIvaDocs = this.fb.group({
        questionario: [null, Validators.required],
        docIdentità: [null , Validators.required],
        curriculum: [null, Validators.required],
        foto: [null, Validators.required],
        visuraCamerale: [null, Validators.required]
      });
      return partitaIvaDocs;
    case 'SOC':
    const societàDocs = this.fb.group({
      questionario: [null, Validators.required],
      visuraCamerale: [null, Validators.required],
      iso9001: [null, Validators.required],
      polizzaRctRco: [null, Validators.required],
      durc: [null, Validators.required],
      bilancio: [null, Validators.required]
    });
    return societàDocs;
  }
  }

  createFG(tipoFornitore: string) {
    this.supplierForm.get('docs2').disable();
    (<FormArray>this.supplierForm.get('docs')).removeAt(0);
    (<FormArray>this.supplierForm.get('docs')).push(this.addDocs(tipoFornitore));
    console.log(this.supplierForm.controls);
  }

  */
}
