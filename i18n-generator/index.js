#!/usr/bin/env node

const XLSX = require('xlsx');
const fs = require('fs');
const path = require('path');

function parseExcelToJSON(excelFilePath) {
  console.log("Starting the parsing process...");

  const workbook = XLSX.readFile(excelFilePath);
  console.log(`Reading excel file from ${excelFilePath}...`);

  const sheetNameList = workbook.SheetNames;
  const ws = workbook.Sheets[sheetNameList[0]];
  const data = XLSX.utils.sheet_to_json(ws);

  console.log("Excel file parsed to JSON.");

  const langs = new Set();
  const langJson = {};

  let lastFeature, lastComponent;

  for (const row of data) {
    let { feature, 'component/scope': component, value, ...rest } = row;

    feature = feature || lastFeature;
    component = component || lastComponent;

    lastFeature = feature;
    lastComponent = component;

    for (const [lang, langValue] of Object.entries(rest)) {
      langs.add(lang);

      if (!langJson[lang]) {
        langJson[lang] = {};
      }

      if (feature && component && value && langValue) {
        deepSet(langJson[lang], feature, component, value, langValue);
      }
    }
  }

  const dir = './src/assets/i18n/gen';

  // Check if directory exists; if not, create it.
  if (!fs.existsSync(dir)) {
    console.log("Directory does not exist. Creating directory...");
    fs.mkdirSync(dir);
  }

  for (const lang of langs) {
    const filePath = path.join(dir, `${lang}.json`);
    fs.writeFileSync(filePath, JSON.stringify(langJson[lang], null, 2));
    console.log(`Generated JSON file for language: ${lang}`);
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
