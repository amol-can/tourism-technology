import { IReward } from '@/types/response.types';

export interface IRewardProps extends IReward {
    onClaim: (id: number) => void;
}
