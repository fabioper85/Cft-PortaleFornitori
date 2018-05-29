import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { UserService } from './shared/user/user.service';
import { HttpClientModule } from '@angular/common/http';
import { UserListComponent } from './user-list/user-list.component';
import { SupplierFormComponent } from './supplier-form/supplier-form.component';
import { RouterModule } from '@angular/router';
import { DocsAreaComponent } from './docs-area/docs-area.component';
import { UploadService } from './shared/upload/upload.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    FooterComponent,
    UserListComponent,
    SupplierFormComponent,
    DocsAreaComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
    {
      path: '',
      component: LoginComponent
    },
    {
      path: 'registration',
      component: SupplierFormComponent
    }
    ])
  ],
  providers: [UserService, UploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
