import React from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";


function DeliveryStatusText(deliveryStatus) {
    return deliveryStatus ? 'Yes' : 'No'
}

export default function HohTableRow({ recipient, handleRecipientClick }) {
    return (
        <Link to='/single-hoh'> <ul className='single-recipient-table__row'
            onClick={() => {
                handleRecipientClick(recipient)
            }}
        >
            <li className='recipient-first-name'>{recipient.firstName}</li>
            <li className='recipient-last-name'>{recipient.lastName}</li>
            <li className='recipient-dob'>{recipient.dateOfBirth}</li>
            <li className='recipient-phone-number'>
                {'(' + recipient.phoneNumber.toString().slice(0, 3) + ') ' +
                    recipient.phoneNumber.toString().slice(3, 6) + '-' +
                    recipient.phoneNumber.toString().slice(6, 10)}
            </li>
            <li className='recipient-address'>{recipient.address}</li>
            <li className='recipient-household'>{recipient.houseSize}</li>
            <li className='recipient-delivery'>{DeliveryStatusText(recipient.deliveryStatus)}</li>
            <li className='recipient-eligible'></li>
        </ul>
        </Link>
    )
}