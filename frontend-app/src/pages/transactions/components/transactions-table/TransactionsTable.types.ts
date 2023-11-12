import { ITransaction } from '@/types/response.types';

export interface ITransactionsTableProps {
    data?: ITransaction[];
    isFetchingData: boolean;
}
