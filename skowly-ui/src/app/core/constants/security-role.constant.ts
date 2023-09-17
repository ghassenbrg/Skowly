export const SecurityRolesData: any = {
  ROLE_SKOWLY_ADMIN: {
    value: 'ROLE_SKOWLY_ADMIN',
    label: 'Skowly Admin',
    imgUrl: '/assets/img/roles/skowly_admin.png',
  },
  ROLE_ADMIN: {
    value: 'ROLE_ADMIN',
    label: 'School Admin',
    imgUrl: '/assets/img/roles/admin.png',
  },
  ROLE_STAFF: {
    value: 'ROLE_STAFF',
    label: 'School Staff',
    imgUrl: '/assets/img/roles/staff.png',
  },
  ROLE_PARENT: {
    value: 'ROLE_PARENT',
    label: 'Parent',
    imgUrl: '/assets/img/roles/parent.png',
  },
  ROLE_STUDENT: {
    value: 'ROLE_STUDENT',
    label: 'Student',
    imgUrl: '/assets/img/roles/student.png',
  },
  ROLE_TEACHER: {
    value: 'ROLE_TEACHER',
    label: 'Teacher',
    imgUrl: '/assets/img/roles/teacher.png',
  },
};

export const rolesList: string[] = Object.keys(SecurityRolesData);
export const rolesDataList: string[] = Object.values(SecurityRolesData);
