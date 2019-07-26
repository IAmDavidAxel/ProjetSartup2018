import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BarberComponent} from './barber/barber.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {BarberDetailComponent} from './barber-detail/barber-detail.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './guard/auth.guard';
import {PaymentComponent} from './payment/payment.component';
import {BarbarProfileComponent} from './barbar-profile/barbar-profile.component';
import {ClientDetailByBarbersComponent} from './client-detail-by-barbers/client-detail-by-barbers.component';
import {AboutComponent} from './about/about.component';
import {RendezVousTableComponent} from './rendez-vous-table/rendez-vous-table.component';
import {RendezVousConfirmationScreenComponent} from './rendez-vous-confirmation-screen/rendez-vous-confirmation-screen.component';


const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'barbers', component: BarberComponent, canActivate: [AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'detail/:name', component: BarberDetailComponent, canActivate: [AuthGuard]
  },
 {path: 'signUp', component: SignUpComponent},
  {path: 'login', component: LoginComponent},

  {path: 'payment', component: PaymentComponent, canActivate: [AuthGuard]},
  {path: 'barberProfile', component: BarbarProfileComponent, canActivate: [AuthGuard]},
  {path: 'profile', component: ClientDetailByBarbersComponent, canActivate: [AuthGuard]},
  {path: 'about', component: AboutComponent},
  {path: 'rendezVousTable', component: RendezVousTableComponent, canActivate: [AuthGuard]},
  {path: 'rendezVousConfirmation', component: RendezVousConfirmationScreenComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
