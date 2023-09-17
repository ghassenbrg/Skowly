export const SecurityRolesData: any = {
  ROLE_SKOWLY_ADMIN: {
    value: 'ROLE_SKOWLY_ADMIN',
    label: 'global.roles.skowlyAdmin',
    imgUrl: '/assets/img/roles/skowly_admin.png',
  },
  ROLE_ADMIN: {
    value: 'ROLE_ADMIN',
    label: 'global.roles.schoolAdmin',
    imgUrl: '/assets/img/roles/admin.png',
  },
  ROLE_STAFF: {
    value: 'ROLE_STAFF',
    label: 'global.roles.schoolStaff',
    imgUrl: '/assets/img/roles/staff.png',
  },
  ROLE_PARENT: {
    value: 'ROLE_PARENT',
    label: 'global.roles.parent',
    imgUrl: '/assets/img/roles/parent.png',
  },
  ROLE_STUDENT: {
    value: 'ROLE_STUDENT',
    label: 'global.roles.student',
    imgUrl: '/assets/img/roles/student.png',
  },
  ROLE_TEACHER: {
    value: 'ROLE_TEACHER',
    label: 'global.roles.teacher',
    imgUrl: '/assets/img/roles/teacher.png',
  },
};

export const rolesList: string[] = Object.keys(SecurityRolesData);
export const rolesDataList: string[] = Object.values(SecurityRolesData);
