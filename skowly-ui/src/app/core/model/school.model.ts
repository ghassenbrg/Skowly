// school.model.ts
export class School {
    id: number| undefined;
    name: string| undefined;
    description: string| undefined;
    address: Address = new Address();
    phoneNumber: string| undefined;
    website: string| undefined;
    email: string| undefined;
    principal: Principal = new Principal();
    totalStudents: number| undefined;
    totalTeachers: number| undefined;
    mapsPosition: string| undefined;
    foundingDate: Date| undefined;
    accreditation: string| undefined;
    facilities: string| undefined;
    extracurricularActivities: string| undefined;
    admissionProcess: string| undefined;
    users: any[]| undefined;
  
    constructor() {
      this.id = 0; // Initialize with a default value, or use an appropriate default value
    }
  }
  
  export class Principal {
    principalName: string| undefined;
    principalEmail: string| undefined;
  }
  
  export class Address {
    streetAddress: string | undefined;
    city: string| undefined;
    state: string| undefined;
    postalCode: string| undefined;
    country: string| undefined;
  }
  
