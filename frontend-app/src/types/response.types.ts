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

export interface IOverviews {
    totalPoints: number;
    nrOfTransactions: number;
}

export interface IReward {
    id: number;
    points: number;
    title: string;
    disabled: boolean;
}

export interface IPaymentSimulation {
    amount: number;
    client: {
        id: number;
    };
    business: {
        id: number;
    };
}
