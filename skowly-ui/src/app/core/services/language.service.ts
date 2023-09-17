import { Injectable } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { supportedLanguages } from '../constants/language.constant';

@Injectable({
  providedIn: 'root',
})
export class LanguageService {
  public direction = 'ltr';
  private defaultLang: string = 'en';

  constructor(private translate: TranslateService) {}

  changeLanguage(language: string, reload?: boolean) {
    let languageObj: any = this.getLanguageObj(language);
    this.changeLanguageByObj(languageObj);
  }

  changeLanguageByObj(languageObj: any, reload?: boolean) {
    this.translate.use(languageObj.value);
    this.direction = languageObj.direction;
    if (reload) {
      location.reload();
    }
  }

  setDefaultLang() {
    this.translate.setDefaultLang(this.defaultLang);
  }

  getDefaultLang() {
    return this.defaultLang;
  }

  getLanguageObj(language: string): any {
    return supportedLanguages[language] ?? supportedLanguages[this.defaultLang];
  }
}
