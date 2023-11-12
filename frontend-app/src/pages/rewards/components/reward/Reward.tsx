import { Box, Button, Card, GridItem, Image, Text } from '@chakra-ui/react';

const Reward = () => {
    return (
        <GridItem>
            <Card borderRadius='10'>
                <Image
                    src='https://images.unsplash.com/photo-1698822311774-dfc1bd0b4ab9?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY5OTc0NDE4OA&ixlib=rb-4.0.3&q=80&w=300'
                    objectFit='cover'
                    h='200px'
                    borderTopRadius='10'
                />
                <Box p='4'>
                    <Text fontWeight='bold' fontSize='large' mb='2'>
                        Title
                    </Text>
                    <Text mb='4'>
                        <strong>Points:</strong> 100
                    </Text>

                    <Button w='100%' colorScheme='blue' variant='outline'>
                        Claim
                    </Button>
                </Box>
            </Card>
        </GridItem>
    );
};

export default Reward;