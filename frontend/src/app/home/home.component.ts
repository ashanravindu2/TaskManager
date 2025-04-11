import { Component } from '@angular/core';
import {TasksComponent} from '../components/tasks/tasks.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone: true,
  imports: [
    TasksComponent
  ],
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  currentView: 'dashboard' | 'projects' | 'app-tasks' | 'calendar' = 'dashboard';

  setView(view: 'dashboard' | 'projects' | 'app-tasks' | 'calendar') {
    this.currentView = view;
  }
}
