import {Component, Input, OnInit} from '@angular/core';
import {ClientDetail} from '../barbar-profile/ClientDetail';

@Component({
  selector: 'app-client-detail-by-barbers',
  templateUrl: './client-detail-by-barbers.component.html',
  styleUrls: ['./client-detail-by-barbers.component.css']
})
export class ClientDetailByBarbersComponent implements OnInit {

   @Input() clientDetails: ClientDetail;

  constructor() { }

  ngOnInit() {
  }

}
