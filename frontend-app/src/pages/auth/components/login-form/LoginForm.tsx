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
import { Form } from './LoginForm.styles';

const LoginForm = (props: LoginFormProps) => {
    const { onSubmit } = props;

    const {
        handleSubmit,
        register,
        formState: { errors, isSubmitting },
    } = useForm({
        defaultValues: {
            username: '',
            password: '',
        },
    });

    return (
        <Box px='6' w='100%' maxW='500px'>
            <Form onSubmit={handleSubmit(onSubmit)}>
                <FormControl isInvalid={!!errors.username} mb='4'>
                    <FormLabel htmlFor='username' fontSize='larger'>
                        Username
                    </FormLabel>
                    <Input
                        id='username'
                        placeholder='Type username here..'
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

                <FormControl isInvalid={!!errors.password} mb='4'>
                    <FormLabel htmlFor='password' fontSize='larger'>
                        Password
                    </FormLabel>
                    <Input
                        id='password'
                        type='password'
                        placeholder='Type password here..'
                        fontSize='larger'
                        height='16'
                        {...register('password', {
                            required: 'This is required',
                        })}
                    />
                    <FormErrorMessage>
                        {errors.password?.message}
                    </FormErrorMessage>
                </FormControl>

                <Button
                    mt={4}
                    colorScheme='teal'
                    isLoading={isSubmitting}
                    type='submit'
                    border='0'
                    w='100%'
                    fontSize='larger'
                    height='16'
                >
                    SUBMIT
                </Button>
            </Form>
        </Box>
    );
};

export default LoginForm;
