import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"

const MainHeader = () => (
    <header className = "main-header">
        <h1 className = "main-header__title">Community Drop In Center</h1>
        <Link to='/'>All Recipients</Link>
    </header>
    
);
export default MainHeader; 