import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UiService {
  private isSidebarExpanded: boolean = true;
  private sidebarExpansionSubject: BehaviorSubject<boolean> = new BehaviorSubject(this.isSidebarExpanded);
  
  // Observable that components can subscribe to for updates on sidebar expansion
  public sidebarExpansion$ = this.sidebarExpansionSubject.asObservable();

  constructor() {}

  toggleSidebar(): void {
    this.isSidebarExpanded = !this.isSidebarExpanded;
    this.sidebarExpansionSubject.next(this.isSidebarExpanded);
  }
}
