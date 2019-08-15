import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"

export default function HohLogin({selectRecipientByPhone}){
    
    let phoneNumber

    return(
        <form className="recipient-login">
            <input type="tel" pattern="[0-9]{3}[0-9]{3}[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="PhoneNumber" onChange={(e) => {
                    e.preventDefault()
                    phoneNumber = e.target.value.replace("-", "").replace("-", "")
                }} />
            <input type="text" placeholder="password"/>
            <Link to="single-hoh" className='give-food-button'onClick={(e) => {
                selectRecipientByPhone(phoneNumber)
            }}>
                Submit
            </Link>
        </form>
    )
}