import { Avatar, Button, Flex, Text, VStack } from '@chakra-ui/react';
import { ExternalLinkIcon } from '@chakra-ui/icons';
import { Link, useLocation } from 'react-router-dom';

const Sidebar = () => {
    const location = useLocation();
    const pathname = location.pathname;

    return (
        <Flex bg='gray.200' p='6' width='250px' as='aside' direction='column'>
            <Flex alignItems='center'>
                <Avatar name='John Smith' />
                <Text as='label' ml='4' fontSize='larger' fontWeight='600'>
                    John Smith
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
            </VStack>

            <Button
                mb='6'
                as={Link}
                to='/'
                border='none'
                bg='transparent'
                textDecoration='none'
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
