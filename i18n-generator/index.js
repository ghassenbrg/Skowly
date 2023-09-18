#!/usr/bin/env node

const XLSX = require('xlsx');
const fs = require('fs');
const path = require('path');

function parseExcelToJSON(excelFilePath) {
  console.log("Starting the parsing process...");

  const workbook = XLSX.readFile(excelFilePath);
  console.log(`Reading excel file from ${excelFilePath}...`);

  const sheetNameList = workbook.SheetNames;

  const masterLangJson = {}; // Master JSON object to hold data from all sheets

  sheetNameList.forEach((sheetName) => { // Iterate through each sheet
    const ws = workbook.Sheets[sheetName];
    const data = XLSX.utils.sheet_to_json(ws);

    console.log(`Parsing sheet: ${sheetName}`);

    let lastFeature, lastComponent;

    for (const row of data) {
      let { feature, 'component/scope': component, value, ...rest } = row;

      feature = feature || lastFeature;
      component = component || lastComponent;

      lastFeature = feature;
      lastComponent = component;

      for (const [lang, langValue] of Object.entries(rest)) {
        if (!masterLangJson[lang]) {
          masterLangJson[lang] = {};
        }

        if (feature && component && value && langValue) {
          deepSet(masterLangJson[lang], feature, component, value, langValue);
        }
      }
    }
  });

  const dir = './src/assets/i18n/gen';

  // Check if directory exists; if not, create it.
  if (!fs.existsSync(dir)) {
    console.log(`Directory ${dir} does not exist. Creating directory...`);
    fs.mkdirSync(dir);
  }

  for (const [lang, jsonData] of Object.entries(masterLangJson)) {
    const filePath = path.join(dir, `${lang}.json`);
    fs.writeFileSync(filePath, JSON.stringify(jsonData, null, 2));
    console.log(`Generated consolidated JSON file for language: ${lang}`);
  }

  console.log("Files have been generated successfully.");
}

function deepSet(obj, feature, component, key, value) {
  if (!obj[feature]) obj[feature] = {};
  if (!obj[feature][component]) obj[feature][component] = {};
  obj[feature][component][key] = value;
}

const excelFilePath = './src/assets/i18n/i18n.xlsx';
parseExcelToJSON(excelFilePath);
