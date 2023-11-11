import {
    TableContainer,
    Table,
    Td,
    Thead,
    Tr,
    Th,
    Tbody,
} from '@chakra-ui/react';

const TransactionsTable = () => {
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
                    <Tr>
                        <Td>1</Td>
                        <Td>10</Td>
                        <Td>11.12.23</Td>
                        <Td>1</Td>
                    </Tr>
                    <Tr>
                        <Td>2</Td>
                        <Td>100</Td>
                        <Td>11.11.23</Td>
                        <Td>100</Td>
                    </Tr>
                </Tbody>
            </Table>
        </TableContainer>
    );
};

export default TransactionsTable;
