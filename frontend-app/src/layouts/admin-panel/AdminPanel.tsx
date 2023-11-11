import { Box, Flex } from '@chakra-ui/react';

import { Sidebar } from './components';

import { AdminPanelProps } from './AdminPanel.types';

const AdminPanelLayout = (props: AdminPanelProps) => {
    const { children } = props;

    return (
        <Flex minHeight='100vh' direction='column'>
            <Flex flex='1'>
                <Sidebar />

                <Flex as='main' flex='1' p='6' flexDirection='column'>
                    <Box flex='1'>{children}</Box>

                    <Box as='footer' textAlign='center'>
                        <Box>Copyright @ {new Date().getFullYear()}</Box>
                    </Box>
                </Flex>
            </Flex>
        </Flex>
    );
};

export default AdminPanelLayout;
