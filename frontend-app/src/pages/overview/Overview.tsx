import {
    Box,
    Card,
    Flex,
    Grid,
    GridItem,
    Heading,
    Text,
} from '@chakra-ui/react';
import { useQuery } from 'react-query';

import { AdminPanelLayout } from '@/layouts';
import client from '@/services/client';

import { useUserStore } from '@/stores';

import { IOverviews } from '@/types/response.types';

const Overview = () => {
    const userData = useUserStore((state) => state.userData);

    const { data } = useQuery('overviewsData', () =>
        client
            .get<IOverviews>(`/dashboard/${userData?.id}`)
            .then((res) => res.data)
    );

    return (
        <AdminPanelLayout>
            <Heading mb='10'>Overview</Heading>
            <Grid
                templateColumns={{
                    base: 'repeat(1, 1fr)',
                    md: 'repeat(2, 1fr)',
                }}
                gap='6'
            >
                <GridItem>
                    <Card height='150' p='6'>
                        <Flex flexDirection='column'>
                            <Text fontSize='larger'>Total points</Text>

                            <Box
                                flex='1'
                                justifyContent='center'
                                alignItems='center'
                            >
                                <Text fontSize='60'>{data?.totalPoints}</Text>
                            </Box>
                        </Flex>
                    </Card>
                </GridItem>

                <GridItem>
                    <Card height='150' p='6'>
                        <Flex flexDirection='column'>
                            <Text fontSize='larger'>Transactions</Text>

                            <Box
                                flex='1'
                                justifyContent='center'
                                alignItems='center'
                            >
                                <Text fontSize='60'>
                                    {data?.nrOfTransactions}
                                </Text>
                            </Box>
                        </Flex>
                    </Card>
                </GridItem>
            </Grid>
        </AdminPanelLayout>
    );
};

export default Overview;
