import React from 'react';

const MainHeader = ({ isLoggedIn, setRoute }) => (
    <header className="main-header">
        <h1 className="main-header__title">Community Drop In Center</h1>
        {isLoggedIn && <nav>
            <button onClick={() => setRoute('form')}>Create User</button>
        </nav>}
    </header>

);
export default MainHeader; 
