import { Routes } from '@angular/router';
import {LoginComponent} from "./auth/login/login.component";
import {LogoutComponent} from "./auth/logout/logout.component";
import {RegisterComponent} from "./auth/register/register.component";
import {Er404Component} from "./errors/404/404.component";
import {HomeComponent} from "./home/home.component";
import {MyProjectsComponent} from "./projects/my-projects/my-projects.component";
import {MyProjectsInviteComponent} from "./projects/my-projects-invite/my-projects-invite.component";
import {ChatcraftComponent} from "./chatcraft/chatcraft.component";

export const routes: Routes = [
  {path: '',component: MyProjectsComponent},
  {path: 'login',component: MyProjectsComponent},
  {path: 'logout',component: MyProjectsComponent},
  {path: 'register',component: MyProjectsComponent},
  {path: 'projects',component: MyProjectsComponent},
  {path: 'projects/invite',component: MyProjectsComponent},
  {path: 'project/:id/dashboard', component: MyProjectsComponent},
  {path: 'project/:id/chat',component: ChatcraftComponent},
  {path: 'project/:id/users',component: MyProjectsComponent},
  {path: 'project/:id/component',component: ChatcraftComponent},
  {path: 'project/:id/export',component: MyProjectsComponent},
  {path: '**',component: Er404Component}
];
