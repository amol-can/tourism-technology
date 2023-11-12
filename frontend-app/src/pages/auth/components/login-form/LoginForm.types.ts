import { TUserFormData } from '@/pages/auth/Auth.types';

export interface LoginFormProps {
    onSubmit: (data: TUserFormData) => void;
    isSubmitting: boolean;
}
