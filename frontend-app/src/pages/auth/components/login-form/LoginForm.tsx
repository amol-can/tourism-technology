import { useForm } from 'react-hook-form';

import {
    FormControl,
    FormLabel,
    Input,
    FormErrorMessage,
    Button,
    Box,
} from '@chakra-ui/react';

import { LoginFormProps } from './LoginForm.types';
import { TUserFormData } from '@/pages/auth/Auth.types';

import { Form } from './LoginForm.styles';

const LoginForm = (props: LoginFormProps) => {
    const { onSubmit, isSubmitting } = props;

    const {
        handleSubmit,
        register,
        formState: { errors },
    } = useForm<TUserFormData>({
        defaultValues: {
            username: '',
            password: '',
        },
    });

    return (
        <Box px='6' w='100%' maxW='500px'>
            <Form onSubmit={handleSubmit(onSubmit)}>
                <FormControl
                    isInvalid={!!errors.username}
                    mb='4'
                    isDisabled={isSubmitting}
                >
                    <FormLabel htmlFor='username' fontSize='larger'>
                        Username
                    </FormLabel>
                    <Input
                        id='username'
                        placeholder='Username here..'
                        fontSize='larger'
                        height='16'
                        {...register('username', {
                            required: 'This is required',
                        })}
                    />
                    <FormErrorMessage>
                        {errors.username?.message}
                    </FormErrorMessage>
                </FormControl>

                <FormControl
                    isInvalid={!!errors.password}
                    mb='4'
                    isDisabled={isSubmitting}
                >
                    <FormLabel htmlFor='password' fontSize='larger'>
                        Password
                    </FormLabel>
                    <Input
                        id='password'
                        type='password'
                        placeholder='Password here..'
                        fontSize='larger'
                        height='16'
                        {...register('password', {
                            required: 'This is required',
                            minLength: {
                                value: 6,
                                message: 'Needs more than 6 characters',
                            },
                        })}
                    />
                    <FormErrorMessage>
                        {errors.password?.message}
                    </FormErrorMessage>
                </FormControl>

                <Button
                    mt={4}
                    colorScheme='blue'
                    isLoading={isSubmitting}
                    type='submit'
                    border='0'
                    w='100%'
                    fontSize='larger'
                    height='16'
                    disabled={isSubmitting}
                >
                    {isSubmitting ? 'Loading...' : 'SUBMIT'}
                </Button>
            </Form>
        </Box>
    );
};

export default LoginForm;
