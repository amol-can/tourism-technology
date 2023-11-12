import { Avatar, Button, Flex, Text, VStack } from '@chakra-ui/react';
import { ExternalLinkIcon } from '@chakra-ui/icons';
import { Link, useLocation } from 'react-router-dom';

import { useUserStore } from '@/stores';
import { UserRole } from '@/types/response.types';

const Sidebar = () => {
    const location = useLocation();
    const pathname = location.pathname;

    const { setUserData, userData } = useUserStore((state) => state);

    return (
        <Flex bg='gray.200' p='6' width='250px' as='aside' direction='column'>
            <Flex alignItems='center'>
                <Avatar name={userData?.fullName} />
                <Text as='label' ml='4' fontSize='larger' fontWeight='600'>
                    {userData?.fullName}
                </Text>
            </Flex>

            <VStack py='20' px='4' flex='1' alignItems='left' spacing='4'>
                <Button
                    as={Link}
                    to='/overview'
                    colorScheme='blue'
                    variant={pathname === '/overview' ? 'solid' : 'ghost'}
                    border='0'
                    textDecoration='none'
                >
                    <Text fontSize='large'>Overview</Text>
                </Button>
                <Button
                    as={Link}
                    to='/transactions'
                    colorScheme='blue'
                    variant={pathname === '/transactions' ? 'solid' : 'ghost'}
                    border='0'
                    textDecoration='none'
                >
                    <Text fontSize='large'>Transactions</Text>
                </Button>

                {userData?.role === UserRole.BUSINESS && (
                    <Button
                        as={Link}
                        to='/rewards'
                        colorScheme='blue'
                        variant={pathname === '/rewards' ? 'solid' : 'ghost'}
                        border='0'
                        textDecoration='none'
                    >
                        <Text fontSize='large'>Rewards</Text>
                    </Button>
                )}

                {userData?.role === UserRole.CUSTOMER && (
                    <Button
                        as={Link}
                        to='/pay-pay'
                        colorScheme='blue'
                        variant={pathname === '/pay-pay' ? 'solid' : 'ghost'}
                        border='0'
                        textDecoration='none'
                    >
                        <Text fontSize='large'>PayPay 💸</Text>
                    </Button>
                )}
            </VStack>

            <Button
                mb='6'
                border='none'
                bg='transparent'
                textDecoration='none'
                onClick={() => setUserData(undefined)}
            >
                <Flex alignItems='center'>
                    <ExternalLinkIcon />
                    <Text fontSize='large' ml='4'>
                        Sign out
                    </Text>
                </Flex>
            </Button>
        </Flex>
    );
};

export default Sidebar;
