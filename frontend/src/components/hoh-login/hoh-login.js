import React, { useState } from 'react';

export default function HohLogin ({ updateLogin, updateRecipient, setRoute }) {

    const [phoneNumber, setPhoneNumber] = useState(0)

    return (
        <div className='recipient-login-container'>
            <form className="recipient-login" onSubmit={(e) => {
                e.preventDefault()
                updateRecipient(phoneNumber)
                updateLogin(phoneNumber)
            }}>
                <h2 className='recipient-login__info-header'>Phone Number</h2>
                <input className='recipient-login__info' type="tel" pattern="[0-9]{3}[0-9]{3}[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="Phone Number" onChange={(e) => setPhoneNumber(e.target.value)} />
                <h2 className='recipient-login__info-header'>Password</h2>
                <input className='recipient-login__info' type="text" placeholder="Password" />
                <h2 className='recipient-login__info-header'/>
                <button className='give-food-button'>Log In</button>
            </form>
            <button className='create-user-button' onClick={() => setRoute('form')}>New User</button>
        </div>
    )
}
