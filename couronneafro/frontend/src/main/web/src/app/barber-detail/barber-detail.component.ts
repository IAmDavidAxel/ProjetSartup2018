import { Component, OnInit, Input} from '@angular/core';

import {Barber} from '../barber/barber';

@Component({
  selector: 'app-barber-detail',
  templateUrl: './barber-detail.component.html',
  styleUrls: ['./barber-detail.component.css']
})
export class BarberDetailComponent implements OnInit {

  @Input() barber: Barber;

  toggled = false;
  handleSelection(event) {
    console.log(event.char);
  }

  constructor() { }

  ngOnInit() {
  }

}
