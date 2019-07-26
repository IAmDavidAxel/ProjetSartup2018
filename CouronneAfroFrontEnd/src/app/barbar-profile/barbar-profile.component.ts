import { Component, OnInit } from '@angular/core';
import {ClientDetail} from './ClientDetail';
import {BarbarProfileService} from './barbar-profile.service';

@Component({
  selector: 'app-barbar-profile',
  templateUrl: './barbar-profile.component.html',
  styleUrls: ['./barbar-profile.component.css']
})
export class BarbarProfileComponent implements OnInit {

  clientDetail: ClientDetail;
  clientDetails: ClientDetail[];
  constructor( private barbarService: BarbarProfileService) { }

  getClientDetail(): void {
    this.barbarService.getClientDetails().subscribe(clientDetails => this.clientDetails = clientDetails);
  }

  ngOnInit() {
    this.getClientDetail();
  }

}
