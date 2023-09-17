import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from './../../auth/auth.service';
import { rolesDataList } from './../../constants/security-role.constant';

@Component({
  selector: 'app-role-selection',
  templateUrl: './role-selection.component.html',
  styleUrls: ['./role-selection.component.scss'],
})
export class RoleSelectionComponent {
  rolesDataList: any[] = [...rolesDataList];
  selectedRole: string | null;

  constructor(
    private readonly router: Router,
    private readonly activatedRoute: ActivatedRoute,
    private auth: AuthenticationService
  ) {
    this.selectedRole = this.auth.getSelectedRole();
  }

  ngOnInit(): void {
    this.rolesDataList = this.rolesDataList.filter((rolesData) =>
      this.auth.getRoles().includes(rolesData.value)
    );
  }

  setSelectedRole(role: string) {
    this.selectedRole = role;
    this.auth.setSelectedRole(this.selectedRole);
    this.activatedRoute.queryParams.subscribe((params) => {
      const targetUrl = params['targetUrl'];
      if (targetUrl) {
        this.router.navigate([targetUrl]);
      } else {
        this.router.navigate(['/']);
      }
    });
  }
}
