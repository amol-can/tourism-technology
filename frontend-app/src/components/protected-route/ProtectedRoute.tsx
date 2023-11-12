import { Navigate, Outlet } from 'react-router-dom';
import { ProtectedRouteProps } from './ProtectedRoute.types';
import { useUserStore } from '@/stores';

const ProtectedRoute = ({ redirectPath = '/' }: ProtectedRouteProps) => {
    const userData = useUserStore((state) => state.userData);

    if (userData === undefined) {
        return <Navigate to={redirectPath} replace />;
    }

    return <Outlet />;
};

export default ProtectedRoute;
