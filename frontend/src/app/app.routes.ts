import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import {RegisterComponent} from './auth/register/register.component';
import {NgModule} from '@angular/core';
import {HomeComponent} from './home/home.component';

export const routes: Routes = [
    { path: '', redirectTo : 'login' , pathMatch: 'full' },
    { path: 'login' , component: LoginComponent },
    { path: 'register' , component: RegisterComponent },
  {
    path: 'home',
    component : HomeComponent,

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
