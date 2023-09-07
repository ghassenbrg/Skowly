import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScoolsListComponent } from './components/scools-list/scools-list.component';
import { RouterModule, Routes } from '@angular/router';
import { CreateSchoolComponent } from './components/create-school/create-school.component';
import { FormsModule } from '@angular/forms';



const schoolRoutes: Routes = [
  {
    path: 'schools',
    component: ScoolsListComponent 
  },
  {
    path: 'create-school',
    component: CreateSchoolComponent 
  }
];

@NgModule({
  declarations: [
    ScoolsListComponent,
    CreateSchoolComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(schoolRoutes),
    FormsModule 
    
  ]
})
export class PlateformManagementModule { }
