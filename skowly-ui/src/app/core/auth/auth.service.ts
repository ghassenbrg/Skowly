import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { keycloak } from 'src/main';
import { LocalStorageKeys } from '../constants/local-storage.constant';
import { SecurityRolesData } from '../constants/security-role.constant';
import { LanguageService } from '../services/language.service';

const defaultProfile: string = 'en';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  constructor(
    private router: Router,
    private languageService: LanguageService
  ) {}

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

  setProfile(profile: string, reload?: boolean): void {
    let languageObj: any = this.languageService.getLanguageObj(profile);
    localStorage.setItem(LocalStorageKeys.profileKey, languageObj.value);
    this.languageService.changeLanguageByObj(languageObj, reload);
  }

  getProfile(): string | null {
    const userInfo: any = this.getUserInfo();
    let profileFromStorage = localStorage.getItem(LocalStorageKeys.profileKey);
    if (!profileFromStorage) {
      profileFromStorage = userInfo?.profile ?? defaultProfile;
      this.setProfile(profileFromStorage as string);
    }
    return profileFromStorage;
  }
}
