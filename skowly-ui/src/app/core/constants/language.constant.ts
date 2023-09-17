export const supportedLanguages: any = {
  en: {
    value: 'en',
    direction: 'ltr',
  },
  fr: {
    value: 'fr',
    direction: 'ltr',
  },
  ar: {
    value: 'ar',
    direction: 'rtl',
  },
};

export const languagesList: string[] = Object.keys(supportedLanguages);
export const languagesDataList: string[] = Object.values(supportedLanguages);
