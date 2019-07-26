import { Component, OnInit } from '@angular/core';
import {ClientDetail} from '../barbar-profile/ClientDetail';
import {BarbarProfileService} from '../barbar-profile/barbar-profile.service';

@Component({
  selector: 'app-rendez-vous-table',
  templateUrl: './rendez-vous-table.component.html',
  styleUrls: ['./rendez-vous-table.component.css']
})
export class RendezVousTableComponent implements OnInit {


  clientDetail: ClientDetail;
  clientDetails: ClientDetail[];

  constructor( private barbarService: BarbarProfileService) { }

  ngOnInit() {
    this.getClientDetail();
  }

  AddClientDetail() {
    localStorage.setItem('clientDetails', JSON.stringify(this.clientDetails));
  }

  getClientDetail(): void {
    this.barbarService.getClientDetails().subscribe(clientDetails => this.clientDetails = clientDetails);
  }

}
