import { Flex, Box, Image, useToast } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';
import { useMutation } from 'react-query';

import axios from 'axios';

import paymentsImg from '@/assets/images/mobile-payment.jpg';
import { LoginForm } from './components';

import { TUserFormData } from './Auth.types';

const Auth = () => {
    const navigate = useNavigate();
    const toast = useToast();

    const { isLoading: isSubmitting, mutate } = useMutation(
        (user: TUserFormData) =>
            axios
                .post('/pay-pay/api/auth/login', user)
                .then((res) => {
                    console.log(res.data);
                    navigate('/overview', { replace: true });
                })
                .catch(() =>
                    toast({
                        status: 'error',
                        description: 'There was an error logging in!',
                    })
                )
    );

    const handleSubmit = (data: TUserFormData) => {
        mutate(data);
    };

    return (
        <Flex alignItems='center' height='100vh'>
            <Box flex='1' height='100%' display={{ base: 'none', md: 'block' }}>
                <Image
                    src={paymentsImg}
                    objectFit='cover'
                    height='100%'
                    maxW='100%'
                />
            </Box>

            <Flex flex='1' alignItems='center' justifyContent='center'>
                <LoginForm
                    onSubmit={handleSubmit}
                    isSubmitting={isSubmitting}
                />
            </Flex>
        </Flex>
    );
};

export default Auth;
