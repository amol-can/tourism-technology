import { Heading } from '@chakra-ui/react';

import { AdminPanelLayout } from '@/layouts';

import { TransactionsTable } from './components';
import { useQuery } from 'react-query';
import client from '@/services/client';

import { ITransaction, UserRole } from '@/types/response.types';
import { useUserStore } from '@/stores';

const Transactions = () => {
    const userData = useUserStore((state) => state.userData);

    const isBusinessUser = userData?.role === UserRole.BUSINESS;

    const { data, isLoading } = useQuery('transactionsData', () =>
        client
            .get<ITransaction[]>(
                `/transactions/${isBusinessUser ? 'business' : 'client'}/${
                    userData?.id
                }`
            )
            .then((res) => res.data)
    );

    return (
        <AdminPanelLayout>
            <Heading size='xl'>Transactions</Heading>
            <TransactionsTable data={data} isFetchingData={isLoading} />
        </AdminPanelLayout>
    );
};

export default Transactions;
