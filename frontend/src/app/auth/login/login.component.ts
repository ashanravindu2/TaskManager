import { Component } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.component.html',
  standalone: true,
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private fb: FormBuilder , private router: Router) {}

  navigateToRegister() {
    this.router.navigate(['/register']);
  }

  navigateHome() {
    this.router.navigate(['/home']);
  }
}
