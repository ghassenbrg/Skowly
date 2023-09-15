import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { SidebarComponent } from './sidebar.component';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { Router } from '@angular/router';
import { NavigationEnd } from '@angular/router';

describe('SidebarComponent', () => {
  let component: SidebarComponent;
  let fixture: ComponentFixture<SidebarComponent>;
  let mockRouter: any;

  beforeEach(async () => {
    mockRouter = {
      url: '/dashboard',
      events: of(new NavigationEnd(0, '/dashboard', '/dashboard'))
    };

    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [SidebarComponent],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              queryParams: { returnUrl: 'test' },
              fragment: 'testFragment'
            }
          }
        },
        {
          provide: Router,
          useValue: mockRouter
        }
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
