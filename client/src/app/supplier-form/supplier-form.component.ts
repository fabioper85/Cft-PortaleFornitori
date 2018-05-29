import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { UploadService } from '../shared/upload/upload.service';
import { HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-supp-form',
  templateUrl: './supplier-form.component.html',
  styleUrls: ['./supplier-form.component.css']
})
export class SupplierFormComponent implements OnInit {

  supplierForm: FormGroup;
  uploadSuccess = false;

  constructor(private fb: FormBuilder, private upload: UploadService) {
    this.createBg(); // <--- inject FormBuilder
    this.createForm();
  }

  ngOnInit() {
    this.supplierForm.controls['societàDocs'].disable();
  }

  submit(event) {
    this.upload.uploadForm(this.createFormData(event))
      .subscribe( events => {
        if (events.type === HttpEventType.Response && events.status === 200) {
          this.uploadSuccess = true;
        }
      } );
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
    document.body.style.backgroundColor = '#333';
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
}
