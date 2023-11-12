import {
    TableContainer,
    Table,
    Td,
    Thead,
    Tr,
    Th,
    Tbody,
} from '@chakra-ui/react';

import { ITransactionsTableProps } from './TransactionsTable.types';

const TransactionsTable = (props: ITransactionsTableProps) => {
    const { data } = props;

    return (
        <TableContainer mt='10'>
            <Table variant='striped'>
                <Thead>
                    <Tr>
                        <Th>ID</Th>
                        <Th>Amount</Th>
                        <Th>Date</Th>
                        <Th>Points</Th>
                    </Tr>
                </Thead>
                <Tbody>
                    {(data ?? []).map((transaction) => (
                        <Tr key={transaction.id}>
                            <Td>{transaction.id}</Td>
                            <Td>{transaction.amount}</Td>
                            <Td>
                                {new Date(transaction.date).getDate()}.
                                {new Date(transaction.date).getMonth()}.
                                {new Date(transaction.date).getFullYear()}
                            </Td>
                            <Td>{transaction.point}</Td>
                        </Tr>
                    ))}
                </Tbody>
            </Table>
        </TableContainer>
    );
};

export default TransactionsTable;
