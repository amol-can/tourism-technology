import { Route, Routes } from 'react-router-dom';
import { Auth, Overview, Rewards, Transactions, PayPay } from '@/pages';
import { ProtectedRoute } from '@/components';

const App = () => {
    return (
        <Routes>
            <Route index path='/' element={<Auth />} />
            <Route element={<ProtectedRoute />}>
                <Route path='overview' element={<Overview />} />
                <Route path='transactions' element={<Transactions />} />
                <Route path='rewards' element={<Rewards />} />
                <Route path='pay-pay' element={<PayPay />} />
            </Route>
            <Route path='*' element={<h1>There's nothing here: 404!</h1>} />
        </Routes>
    );
};

export default App;
