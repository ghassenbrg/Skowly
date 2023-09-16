export interface MenuItem {
    label: string,
    path: string,
    icon?: string,
    color: string,
    subMenu?: MenuItem[]
    roles?:String[]
}