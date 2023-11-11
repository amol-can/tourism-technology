import { Flex, Box, Image } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';

import paymentsImg from '@/assets/images/mobile-payment.jpg';
import { LoginForm } from './components';

const Auth = () => {
    const navigate = useNavigate();

    const handleSubmit = (data: unknown) => {
        navigate('/overview', { replace: true });
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
                <LoginForm onSubmit={handleSubmit} />
            </Flex>
        </Flex>
    );
};

export default Auth;
