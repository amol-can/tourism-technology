import { Route, Routes } from 'react-router-dom';
import { Auth, Dashboard, Rewards, Transactions } from '@/pages';
import { ProtectedRoute } from '@/components';

const App = () => {
    return (
        <Routes>
            <Route index path='/' element={<Auth />} />
            <Route element={<ProtectedRoute />}>
                <Route path='dashboard' element={<Dashboard />} />
                <Route path='transactions' element={<Transactions />} />
                <Route path='rewards' element={<Rewards />} />
            </Route>
            <Route path='*' element={<h1>There's nothing here: 404!</h1>} />
        </Routes>
    );
};

export default App;
