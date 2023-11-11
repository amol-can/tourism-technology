import { Flex, Box, Image } from '@chakra-ui/react';

import paymentsImg from '@/assets/images/mobile-payment.jpg';
import { LoginForm } from './components';

function Auth() {
    const handleSubmit = (data: unknown) => {
        console.log(data);
    };

    return (
        <Flex alignItems='center' height='100vh'>
            <Box flex='1' height='100%'>
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
}

export default Auth;
