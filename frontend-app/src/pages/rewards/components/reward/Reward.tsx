import { Box, Button, Card, GridItem, Image, Text } from '@chakra-ui/react';

import { IRewardProps } from './Reward.types';
import { CheckCircleIcon } from '@chakra-ui/icons';

const Reward = (props: IRewardProps) => {
    const { id, points, title, onClaim, disabled } = props;

    return (
        <GridItem>
            <Card borderRadius='10'>
                <Image
                    src='https://media.istockphoto.com/id/1150233756/photo/businessman-working-and-discussing-business-together.jpg?s=612x612&w=0&k=20&c=6cUwfpiLrRYaKmEW6Qd26qqQkoWpMW7rlXIxcXbGvsY='
                    objectFit='cover'
                    h='200px'
                    borderTopRadius='10'
                />
                <Box p='4'>
                    <Text fontWeight='bold' fontSize='large' mb='2'>
                        {title}
                    </Text>
                    <Text mb='4'>
                        <strong>Points:</strong> {points}
                    </Text>

                    <Button
                        w='100%'
                        colorScheme={disabled ? 'gray' : 'green'}
                        color={disabled ? 'gray' : 'green.400'}
                        variant='outline'
                        onClick={() => onClaim(id)}
                        disabled={disabled}
                    >
                        Claim <CheckCircleIcon ml='3' />
                    </Button>
                </Box>
            </Card>
        </GridItem>
    );
};

export default Reward;
