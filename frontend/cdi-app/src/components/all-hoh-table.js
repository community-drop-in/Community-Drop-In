import React from 'react'
import HohTableRow from './all-hoh-table-components/hoh-table-row'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default function HohTable({ recipients, handleRecipientClick }) {
    return (
        <>
            <article className='results-article'>
                <ul className='results-table__head'>
                    <li className='head__firstname'>First Name</li>
                    <li className='head__lastname'>Last Name</li>
                    <li className='head__dob'>DOB</li>
                    <li className='head__phone'>Phone #</li>
                    <li className='head__address'>Address</li>
                    <li className='head__household'>Household</li>
                    <li className='head__delivery'>Delivery</li>
                    <li className='head__eligible'>Eligible</li>
                </ul>
                {recipients.map(recipient => <HohTableRow recipient={recipient} handleRecipientClick={handleRecipientClick} />)}

            </article>
            <div className='new-recipient-div'>
            <Link to='/hoh-form' className="new-recipient-button">Add New Recipient</Link>
            </div>
        </>
    )
}




