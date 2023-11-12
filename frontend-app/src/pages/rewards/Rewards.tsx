import { Heading, Grid } from '@chakra-ui/react';

import { AdminPanelLayout } from '@/layouts';
import { Reward } from './components';

const Rewards = () => {
    return (
        <AdminPanelLayout>
            <Heading>Rewards</Heading>
            <Grid
                templateColumns={{
                    base: 'repeat(1, 1fr)',
                    md: 'repeat(2, 1fr)',
                    lg: 'repeat(3, 1fr)',
                }}
                gap='6'
                mt='10'
            >
                <Reward />
                <Reward />
                <Reward />
                <Reward />
            </Grid>
        </AdminPanelLayout>
    );
};

export default Rewards;
