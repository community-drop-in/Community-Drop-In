import React from 'react';

const MainHeader = ({ isLoggedIn, setRoute  }) => (
    <header className="main-header">
        <h1 className="main-header__title">Community Drop In Center</h1>
<<<<<<< HEAD
=======
        {!isLoggedIn && <nav>
            <button onClick={() => setRoute('table')}>Table</button>
            <button onClick={() => setRoute('form')}>Create User</button>
        </nav>}
>>>>>>> ede49419eb94917209b70fde4cd9e218482a02fb
    </header>

);
export default MainHeader; 
