import { IUser } from '@/types/response.types';

export type TUserFormData = Pick<IUser, 'username' | 'password'>;
