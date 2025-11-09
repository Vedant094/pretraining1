import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { UserAuth } from "./components/user-auth/user-auth";

@Component({
  selector: 'app-root',
  imports: [FormsModule, UserAuth],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('crud-ops');
}
