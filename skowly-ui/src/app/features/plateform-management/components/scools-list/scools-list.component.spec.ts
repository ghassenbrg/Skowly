import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScoolsListComponent } from './scools-list.component';

describe('ScoolsListComponent', () => {
  let component: ScoolsListComponent;
  let fixture: ComponentFixture<ScoolsListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ScoolsListComponent]
    });
    fixture = TestBed.createComponent(ScoolsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
