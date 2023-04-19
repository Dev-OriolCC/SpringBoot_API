import React from 'react';
import logo from './logo.svg';
import './App.css';
// import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
//import { BrowserRouter as Router, Routes as Switch, Route } from 'react-router-dom';

import Navbar from './components/common/Navbar';
import routes from './config/routes';
//import { Routes } from 'react-router-dom';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Navbar />
          <Routes>
            {routes.map(({ path, element }) => (
              <Route key={path} path={path} element={React.createElement(element)} />
            ))}
          </Routes>
        </Router>
        
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Real State App!</h1>
        <p>
          Hello World!
        </p>
      </header>
      
      
    </div>
  );
}

export default App;
