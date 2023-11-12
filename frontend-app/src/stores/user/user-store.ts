import { create } from 'zustand';
import { persist } from 'zustand/middleware';

import { IUserState } from './user-store.types';

const useUserStore = create<IUserState>()(
    persist(
        (set, get) => ({
            userData: undefined,
            setUserData: (newUserData) =>
                set(() => ({ ...get(), userData: newUserData })),
        }),
        {
            name: 'user-storage',
        }
    )
);

export default useUserStore;
