import {Component, Input, OnInit} from '@angular/core';
import {Barber} from '../barber/barber';


@Component({
  selector: 'app-rendez-vous-confirmation-screen',
  templateUrl: './rendez-vous-confirmation-screen.component.html',
  styleUrls: ['./rendez-vous-confirmation-screen.component.css']
})
export class RendezVousConfirmationScreenComponent implements OnInit {

 @Input() barber: Barber;
  constructor() { }

  ngOnInit() {
  }

}
