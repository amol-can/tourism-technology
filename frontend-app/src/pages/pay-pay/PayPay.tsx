import { useMutation } from 'react-query';

import { Text, Flex, Heading, Image, useToast, Button } from '@chakra-ui/react';

import { AdminPanelLayout } from '@/layouts';

import client from '@/services/client';

import { useUserStore } from '@/stores';

import { IPaymentSimulation } from '@/types/response.types';

import cardsIllustration from '@/assets/images/cards-illustration.jpeg';

const PayPay = () => {
    const userData = useUserStore((state) => state.userData);
    const toast = useToast();

    const paymentSimulation: IPaymentSimulation = {
        amount: 100,
        client: {
            id: userData?.id as number,
        },
        business: {
            id: 1,
        },
    };

    const { isLoading: isPaying, mutate } = useMutation(() =>
        client
            .post('/transactions', paymentSimulation)
            .then(() => {
                toast({
                    status: 'success',
                    description: 'Your payment was successful!',
                });
            })
            .catch(() =>
                toast({
                    status: 'error',
                    description: 'There was an error paying!',
                })
            )
    );

    return (
        <AdminPanelLayout>
            <Flex direction='column'>
                <Heading>PayPay 💸</Heading>
                <Flex
                    flex='1'
                    justifyContent='center'
                    flexDirection='column'
                    alignItems='center'
                >
                    <Image
                        src={cardsIllustration}
                        alt='Cards illustration'
                        height='450'
                    />

                    <Text fontSize='larger' mt='6' mb='4'>
                        <strong>Points:</strong> {paymentSimulation.amount}
                    </Text>

                    <Text fontSize='larger' mb='10'>
                        <strong>Amount:</strong> {paymentSimulation.amount}
                    </Text>

                    <Button
                        colorScheme='blue'
                        border='none'
                        size='lg'
                        disabled={isPaying}
                        onClick={() => mutate()}
                    >
                        {isPaying
                            ? 'Processing payment...'
                            : 'Complete payment'}
                    </Button>
                </Flex>
            </Flex>
        </AdminPanelLayout>
    );
};

export default PayPay;
