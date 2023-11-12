import { IUser } from '@/types/response.types';

export interface IUserState {
    userData?: IUser;
    setUserData: (user: IUser) => void;
}
