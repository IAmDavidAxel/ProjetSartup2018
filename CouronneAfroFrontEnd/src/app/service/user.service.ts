import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {User} from '../model/user';
import {environment} from '../../environments/environment';



@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(`${environment.API_URL}/users`);
  }

  getById(id: number) {
    return this.http.get(`${environment.API_URL}/users/${id}`);
  }

  register(user: User) {
    return this.http.post(`${environment.API_URL}/users/signUp`, user);
  }

  update(user: User) {
    return this.http.put(`${environment.API_URL}/users/${user.id}`, user);
  }

  delete(id: number) {
    return this.http.delete(`${environment.API_URL}/users/${id}`);
  }

  isBarber(user: User) {
   user.isBarber = true;
  }
}
