import { Component } from '@angular/core';
import {environment} from "../../../environments/environment";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-register',
  standalone: true,
    imports: [
        RouterLink
    ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  serverDomain = environment.serverDomain;
}
