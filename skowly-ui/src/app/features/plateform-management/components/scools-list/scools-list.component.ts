import { Component, OnInit } from '@angular/core';
import { School } from 'src/app/core/models/school.model';
import { SchoolService } from '../../services/school-service.service';

@Component({
  selector: 'app-scools-list',
  templateUrl: './scools-list.component.html',
  styleUrls: ['./scools-list.component.scss']
})
export class ScoolsListComponent implements OnInit {
  schools: School[] = [];

  constructor(private schoolService: SchoolService) {}

ngOnInit(): void {
  // Call the SchoolService to initialize the list of schools
  this.schoolService.getAllSchools().subscribe((schools) => {
    this.schools = schools;
    console.log('Schools:', this.schools); // Add this line for debugging
  });
}

  editSchool(school: School) {

    console.log('Edit School:', school);
  }

  deleteSchool(school: School) {
    this.schoolService.deleteSchool(school.id).subscribe(() => {
      // After deleting, refresh the list of schools
      this.loadSchools();
    });
  }
  private loadSchools() {
    // Call the SchoolService to initialize the list of schools
    this.schoolService.getAllSchools().subscribe((schools) => {
      this.schools = schools;
      console.log('Schools:', this.schools); // Add this line for debugging
    });
  }
}