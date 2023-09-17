import { Injectable } from '@angular/core';
import { AuthenticationService } from '../auth/auth.service';
import { LanguageService } from './language.service';

@Injectable({ providedIn: 'root' })
export class AppInitializer {
  constructor(
    private auth: AuthenticationService,
    private languageService: LanguageService
  ) {}

  // Initialization Methods
  async initializeApp(): Promise<void> {
    try {
      this.auth.getSelectedRole();
      const userInfo: any = this.auth.getUserInfo();
      this.languageService.setDefaultLang();
      let currentProfile = this.auth.getProfile();
      if (!currentProfile) {
        currentProfile =
          userInfo?.profile ?? this.languageService.getDefaultLang();
        this.auth.setProfile(currentProfile as string);
      } else {
        this.languageService.changeLanguage(currentProfile);
      }
    } catch (error) {
      console.error('Failed to initialize app:', error);
      throw error;
    }
  }
}
