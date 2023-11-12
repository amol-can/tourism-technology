import { AdminPanelLayout } from '@/layouts';
import { Card, Heading } from '@chakra-ui/react';

const Overview = () => {
    return (
        <AdminPanelLayout>
            <Heading mb='6'>Overview</Heading>
            <Card>Total</Card>
        </AdminPanelLayout>
    );
};

export default Overview;
