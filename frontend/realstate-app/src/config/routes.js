import React from 'react';
// import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from '../pages/Home';
// import About from './views/About';
// import Contact from './views/Contact';
// import NotFound from './views/NotFound';

const routes = [
    {
        path: '/home',
        name: 'Home',
        element: <Home />
    }
];

export default routes;