export enum UserRole {
    BUSINESS = 'BUSINESS',
    CUSTOMER = 'CUSTOMER',
}

export interface IUser {
    id: number;
    username: string;
    password: string;
    fullName: string;
    role: UserRole;
}

export interface ITransaction {
    id: number;
    amount: number;
    date: string;
    point: number;
}
