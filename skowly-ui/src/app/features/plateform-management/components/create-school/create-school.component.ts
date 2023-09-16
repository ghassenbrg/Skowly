import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router'; // Import Router for navigation
import { SchoolService } from '../../services/school-service.service';
import { School } from 'src/app/core/models/school.model';

@Component({
  selector: 'app-create-school',
  templateUrl: './create-school.component.html',
  styleUrls: ['./create-school.component.scss']
})
export class CreateSchoolComponent implements OnInit {
  newSchool!: School // Initialize a new School object

  constructor(private schoolService: SchoolService, private router: Router) {}

  ngOnInit(): void {
    this.newSchool = new School();
  }

  createSchool() {
    console.log(this.newSchool)
    // Call the SchoolService to create the new school
    this.schoolService.createSchool(this.newSchool).subscribe((createdSchool) => {
      // Handle the response, e.g., show a success message or navigate to another page
      console.log('Created School:', createdSchool);
      // Navigate to a different page after creating the school
      this.router.navigate(['/dashboard/platform-management/schools']);
    });
  }
}