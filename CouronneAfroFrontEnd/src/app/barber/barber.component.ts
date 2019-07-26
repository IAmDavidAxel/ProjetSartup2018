import { Component, OnInit } from '@angular/core';
import {Barber} from './barber';
import {BARBER} from './mock-barbers';
import {BarberService} from './barber.service';
import {MessageService} from '../messages/message.service';

@Component({
  selector: 'app-barber',
  templateUrl: './barber.component.html',
  styleUrls: ['./barber.component.css']
})
export class BarberComponent implements OnInit {
  selectedBarber: Barber;
  barbers = BARBER;
  onSelect(barber: Barber): void {
    this.selectedBarber = barber;
  }
  getBarbers(): void {
    this.barberService.getBarbers().subscribe(barbers => this.barbers = barbers);
  }
  constructor(
    private barberService: BarberService) { }

  ngOnInit() {
    this.getBarbers();
  }

}
