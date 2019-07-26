import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {ClientDetail} from './ClientDetail';
import {MessageService} from '../messages/message.service';


@Injectable({
  providedIn: 'root'
})
export class BarbarProfileService {

  constructor(private messageService: MessageService) { }


  clientDetails: any[] = JSON.parse(localStorage.getItem('clientDetails')) || [];

  getClientDetails(): Observable<ClientDetail[]> {

    return of(this.clientDetails);
  }

}
