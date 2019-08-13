import React, {useEffect, useState} from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const Api = () => {

	const [recipients, setRecipients] = useState([]);
	const[showAllRecipients, setShowAllRecipients] = useState(true);
	
	useEffect(() =>{
		fetch(getRootURL() + 'recipients')
		.then(response => response.json())
		.then(recipients => setRecipients(recipients))
	}, [])
	
	if(recipients !==undefined && showAllRecipients){
		return (
			<HohTable recipients={recipients}/>
		)
	}
}

function DeliveryStatusText (deliveryStatus) {
    if (deliveryStatus == true) {
        return 'Yes';
    }
    return 'No';
 }

function getRootURL() {
	return 'http://localhost:8080/api/';
}

function HohTable({recipients}) {
	return(
		<table className='results-table'>
		<tbody className='results-table__body'>
			<tr className='results-table__head'>
				<th className='head__firstname'>First Name</th>
				<th className='head__lastname'>Last Name</th>
				<th className='head__dob'>DOB</th>
				<th className='head__phone'>Phone #</th>
				<th className='head__address'>Address</th>
				<th className='head__household'>Household</th>
				<th className='head__delivery'>Delivery</th>
				<th className='head__eligible'>Eligible</th>
			</tr>
			{recipients.map(recipient => (
				<HohTableRow recipient={recipient} />
			))}
		</tbody>
	</table>
	)
}

function HohTableRow({recipient}) {
    return (
    <tr className='single-recipient-table__row' 
        onClick={() => {alert('you clicked on '+recipient.firstName)}}
        >
        <th className='recipient-first-name'>{recipient.firstName}</th>
        <th className='recipient-last-name'>{recipient.lastName}</th>
        <th className='recipient-dob'>{recipient.dateOfBirth}</th>
        <th className='recipient-phone-number'>
        {'(' + recipient.phoneNumber.toString().slice(0,3) + ') ' +
            recipient.phoneNumber.toString().slice(3,6) + '-' +
            recipient.phoneNumber.toString().slice(6,10)}
        </th>
        <th className='recipient-address'>{recipient.address}</th>
        <th className='recipient-household'>{recipient.houseSize}</th>
        <th className='recipient-delivery'>{DeliveryStatusText(recipient.deliveryStatus)}</th>
        <th className='recipient-eligible'></th>
    </tr>
    )
}

export default Api