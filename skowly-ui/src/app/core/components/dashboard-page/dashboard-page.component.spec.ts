import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { DashboardPageComponent } from './dashboard-page.component';
import { RouterTestingModule } from '@angular/router/testing'; // Import RouterTestingModule
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs'; // Import of from rxjs
import { HeaderComponent } from '../header/header.component';

describe('DashboardPageComponent', () => {
  let component: DashboardPageComponent;
  let fixture: ComponentFixture<DashboardPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],  // Add RouterTestingModule to the imports array
      declarations: [ DashboardPageComponent, SidebarComponent, HeaderComponent ],
      providers: [
        {
          provide: ActivatedRoute, // Add a mock ActivatedRoute provider
          useValue: {
            snapshot: {
              queryParams: of({}),
              fragment: of('')
            }
          }
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
