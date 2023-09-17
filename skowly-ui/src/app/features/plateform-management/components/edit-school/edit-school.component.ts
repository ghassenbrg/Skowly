import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SchoolService } from '../../services/school-service.service';
import { Address, Principal, School } from 'src/app/core/models/school.model';

@Component({
  selector: 'app-edit-school',
  templateUrl: './edit-school.component.html',
  styleUrls: ['./edit-school.component.scss']
})
export class EditSchoolComponent {
  school!: School;
  constructor(private route: ActivatedRoute, private router : Router,private schoolService: SchoolService,) {
    this.school = new School();
    this.route.params.subscribe((params) => {
      const schoolId = +params['schoolId'];
      this.schoolService.getSchoolById(schoolId).subscribe(
        (school) => {
          this.school = school;
        }
      );
    }); 
  }

  save() {
    this.schoolService.updateSchool(this.school.id!, this.school).subscribe(
      (updatedSchool) => {
        this.router.navigate(['/dashboard/platform-management/schools']);
      },
      (error) => {
        console.error('Error updating school:', error);
      }
    );    
  }

  cancel(){
    this.router.navigate(['/dashboard/platform-management/schools']);
  }
}
