import { Avatar, Button, Flex, Text, VStack } from '@chakra-ui/react';
import { ExternalLinkIcon } from '@chakra-ui/icons';

const Sidebar = () => {
    return (
        <Flex bg='gray.200' p='6' width='250px' as='aside' direction='column'>
            <Flex alignItems='center'>
                <Avatar name='John Smith' />
                <Text as='label' ml='4' fontSize='larger' fontWeight='600'>
                    John Smith
                </Text>
            </Flex>

            <VStack
                py='20'
                px='4'
                flex='1'
                fontSize='large'
                alignItems='left'
                spacing='4'
            >
                <Button colorScheme='blue' border='0'>
                    <Text fontSize='large'>Overview</Text>
                </Button>
                <Button bg='transparent' border='0'>
                    <Text fontSize='large'>Transactions</Text>
                </Button>
                <Button bg='transparent' border='0'>
                    <Text fontSize='large'>Rewards</Text>
                </Button>
            </VStack>

            <Flex alignItems='center' fontSize='large' mb='6'>
                <ExternalLinkIcon />
                <Text ml='4'>Sign out</Text>
            </Flex>
        </Flex>
    );
};

export default Sidebar;
