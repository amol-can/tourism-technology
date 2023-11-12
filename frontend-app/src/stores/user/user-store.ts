import { create } from 'zustand';

import { IUserState } from './user-store.types';

const useUserStore = create<IUserState>((set) => ({
    userData: undefined,
    setUserData: (newUserData) =>
        set((state) => ({ ...state, userData: newUserData })),
}));

export default useUserStore;
