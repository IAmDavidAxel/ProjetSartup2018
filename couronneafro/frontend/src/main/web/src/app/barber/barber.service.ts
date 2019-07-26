import { Injectable } from '@angular/core';
import {Barber} from './barber';
import {BARBER} from './mock-barbers';
import {Observable, of} from 'rxjs';
import {MessageService} from '../messages/message.service';

@Injectable({
  providedIn: 'root'
})
export class BarberService {
  constructor(private messageService: MessageService) { }

    getBarbers(): Observable<Barber[]> {
      this.messageService.add('BarberService: fetched barbers');
      return of (BARBER);
    }
}
