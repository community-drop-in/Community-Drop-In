import React, { useState } from 'react';

export default function HohLogin ({ updateLogin, updateRecipient }) {

    const [phoneNumber, setPhoneNumber] = useState(0)

    return (
        <form className="recipient-login" onSubmit={(e) => {
            e.preventDefault()
            updateRecipient(phoneNumber)
            updateLogin()
        }}>
            <input type="tel" pattern="[0-9]{3}[0-9]{3}[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="PhoneNumber" onChange={(e) => setPhoneNumber(e.target.value)} />
            <input type="text" placeholder="password" />
            <button className='give-food-button'>Submit</button>
        </form>
    )
}
