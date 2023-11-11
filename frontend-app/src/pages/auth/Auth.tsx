import { Flex, Box, Image } from '@chakra-ui/react';

import paymentsImg from '@/assets/images/mobile-payment.jpg';

function Auth() {
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
            <Box flex='1'></Box>
        </Flex>
    );
}

export default Auth;
