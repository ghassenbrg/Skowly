import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScoolsListComponent } from './components/scools-list/scools-list.component';
import { RouterModule, Routes } from '@angular/router';
import { CreateSchoolComponent } from './components/create-school/create-school.component';
import { FormsModule } from '@angular/forms';
import { EditSchoolComponent } from './components/edit-school/edit-school.component';



const schoolRoutes: Routes = [
  {
    path: 'schools',
    component: ScoolsListComponent 
  },
  {
    path: 'create-school',
    component: CreateSchoolComponent 
  },
  { 
    path: 'edit-school/:schoolId',
    component: EditSchoolComponent
  }
];

@NgModule({
  declarations: [
    ScoolsListComponent,
    CreateSchoolComponent,
    EditSchoolComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(schoolRoutes),
    FormsModule 
    
  ]
})
export class PlateformManagementModule { }
