import { Component, OnInit } from '@angular/core';
import {MessageService} from '../messages/message.service';
import {BarberService} from '../barber/barber.service';
import {Barber} from '../barber/barber';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  barbers: Barber[];

  constructor(private barberService: BarberService) { }

  ngOnInit() {
    this.getBarbers();
  }

  getBarbers(): void {
    this.barberService.getBarbers().subscribe(barbers => this.barbers = barbers.slice(1, 5));
  }

}
