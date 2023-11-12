import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ThemeProvider } from '@chakra-ui/react';
import { createStandaloneToast } from '@chakra-ui/toast';
import { QueryClient, QueryClientProvider } from 'react-query';

import App from './App';

import { theme } from '@chakra-ui/theme';

import '@/assets/styles/global.css';

const queryClient = new QueryClient();

const { ToastContainer } = createStandaloneToast();

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <BrowserRouter>
                <ToastContainer />
                <ThemeProvider theme={theme}>
                    <App />
                </ThemeProvider>
            </BrowserRouter>
        </QueryClientProvider>
    </React.StrictMode>
);
