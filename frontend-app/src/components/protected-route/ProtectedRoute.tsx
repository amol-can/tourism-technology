import { Navigate, Outlet } from 'react-router-dom';
import { ProtectedRouteProps } from './ProtectedRoute.types';

const ProtectedRoute = ({ redirectPath = '/' }: ProtectedRouteProps) => {
    const isLoggedIn = true;

    if (!isLoggedIn) {
        return <Navigate to={redirectPath} replace />;
    }

    return <Outlet />;
};

export default ProtectedRoute;
