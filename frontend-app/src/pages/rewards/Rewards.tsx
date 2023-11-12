import { Heading, Grid, useToast } from '@chakra-ui/react';
import { useMutation, useQuery } from 'react-query';

import { AdminPanelLayout } from '@/layouts';
import { Reward } from './components';
import client from '@/services/client';
import { useUserStore } from '@/stores';

import { IReward } from '@/types/response.types';

const Rewards = () => {
    const userData = useUserStore((state) => state.userData);
    const toast = useToast();

    const { data, refetch } = useQuery('rewardsData', () =>
        client
            .get<IReward[]>(`/rewards/${userData?.id}`)
            .then((res) => res.data)
    );

    const { mutate } = useMutation((rewardId: number) =>
        client
            .post('/rewards', { rewardId, businessId: userData?.id })
            .then(() => {
                toast({
                    status: 'success',
                    description: 'The reward was claimed!',
                });
                refetch();
            })
            .catch(() =>
                toast({
                    status: 'error',
                    description: 'There was an error logging in!',
                })
            )
    );

    return (
        <AdminPanelLayout>
            <Heading>Rewards</Heading>
            <Grid
                templateColumns={{
                    base: 'repeat(1, 1fr)',
                    md: 'repeat(2, 1fr)',
                    lg: 'repeat(3, 1fr)',
                    xl: 'repeat(4, 1fr)',
                }}
                gap='6'
                mt='10'
            >
                {data?.map((reward) => (
                    <Reward
                        key={reward.id}
                        {...reward}
                        onClaim={(rewardId) => mutate(rewardId)}
                    />
                ))}
            </Grid>
        </AdminPanelLayout>
    );
};

export default Rewards;
