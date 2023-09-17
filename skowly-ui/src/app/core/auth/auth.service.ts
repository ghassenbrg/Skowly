import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { keycloak } from 'src/main';
import { LocalStorageKeys } from '../constants/local-storage.constant';
import { SecurityRolesData } from '../constants/security-role.constant';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  constructor(private router: Router) {}

  // Initialization Methods
  async initializeApp(): Promise<void> {
    try {
      this.getSelectedRole();
      const userInfo: any = this.getUserInfo();

      if (!this.getProfile()) {
        this.setProfile(userInfo?.profile ?? 'en');
      }
    } catch (error) {
      console.error('Failed to initialize app:', error);
      throw error;
    }
  }

  // Auth Methods
  isAuthenticated(): boolean {
    return Boolean(keycloak.authenticated);
  }

  login(targetPath?: string): void {
    const targetUrl = decodeURIComponent(
      window.location.origin + (targetPath || this.router.url)
    );
    keycloak.login({ redirectUri: targetUrl });
  }

  logout(targetPath?: string): void {
    const targetUrl = decodeURIComponent(
      window.location.origin + (targetPath || this.router.url)
    );
    keycloak.logout({ redirectUri: targetUrl });
  }

  // Role Methods
  getRoles(): string[] {
    return (
      keycloak.realmAccess?.roles
        ?.filter((value) => SecurityRolesData[`ROLE_${value}`])
        .map((value) => `ROLE_${value}`) ?? []
    );
  }

  setSelectedRole(role: string): void {
    if (!role || this.getRoles().includes(role)) {
      localStorage.setItem(LocalStorageKeys.roleStorageKey, role);
    }
  }

  getSelectedRole(): string {
    let selectedRole = localStorage.getItem(LocalStorageKeys.roleStorageKey);
    if (selectedRole && !this.getRoles().includes(selectedRole)) {
      if (!this.setDefaultRoleIfSingle()) {
        this.setSelectedRole('');
      }
      selectedRole = localStorage.getItem(LocalStorageKeys.roleStorageKey);
    }
    return selectedRole ?? '';
  }

  private setDefaultRoleIfSingle(): boolean {
    const roles = this.getRoles();
    if (roles.length === 1) {
      this.setSelectedRole(roles[0]);
      return true;
    }
    return false;
  }

  // Profile Methods
  getUserInfo(): any {
    return keycloak.userInfo ?? {};
  }

  setProfile(profile: string): void {
    localStorage.setItem(LocalStorageKeys.profileKey, profile);
  }

  getProfile(): string | null {
    return localStorage.getItem(LocalStorageKeys.profileKey);
  }
}
