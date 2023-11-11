import { Heading } from '@chakra-ui/react';

import { AdminPanelLayout } from '@/layouts';

import { TransactionsTable } from './components';

const Transactions = () => {
    return (
        <AdminPanelLayout>
            <Heading size='xl'>Transactions</Heading>
            <TransactionsTable />
        </AdminPanelLayout>
    );
};

export default Transactions;
