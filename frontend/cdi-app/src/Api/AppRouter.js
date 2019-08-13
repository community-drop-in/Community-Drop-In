import React, {useEffect, useState} from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const AppRouter = () => {

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
    if (deliveryStatus === true) {
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

function InfoAddress({address}) {
    return (
        <section className='info-section address'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title address-title'>Address:</h3>
                <h4 className='info-section__content-div__content address-value'>{address}</h4>
            </div>
            <button className='info-section__button address-modify-button'>Change Address</button>
        </section>
    );
} 

function InfoDelivery({deliveryStatus}) {
    return (
        <section className='info-section delivery-status'>
        <div className='info-section__content-div'>
            <h3 className='info-section__content-div__title delivery-status-title'>Delivery:</h3>
            <h4 className='info-section__content-div__content delivery-status-value'>{DeliveryStatusText(deliveryStatus)}</h4>
        </div>
        <button className='info-section__modify-button'>Remove Delivery</button>
    </section>
    ); 
} 

function InfoDOB({dateOfBirth}) {
    return (
        <section className='info-section dob'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title dob-title'>DOB:</h3>
                <h4 className='info-section__content-div__content dob-value'>{dateOfBirth}</h4>
            </div>
        </section>
    );
} 

function InfoNameHeader({recipient}){
    return (
        <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
        );
} 

function InfoOrder({order}) {
    return (
        <tr className='order-row'>
            <td className='size-td'>{order.size}</td>
            <td className='date-td'>{order.date}</td>
        </tr>
    );    
} 

function InfoOrderList ({orders}) {
    return (
        <table className='order-table'>
            <thead className='order-table__head'>
                <tr className='order-table__title-row'>
                    <th className='order-table-title' colSpan='2'>ORDERS</th>
                </tr>
            </thead>
            <tbody className='order-table__body'>
                <tr>
                    <td className='size-td-label'>PEOPLE</td>
                    <td className='date-td-label'>DATE</td>
                </tr>
                console.log(orders);
                {orders.map(order => <InfoOrder order={order} />)}
            </tbody>
        </table>
    );
} 

function InfoPhone({phoneNumber}) {
    return (
        <section className='info-section phone'>
        <div className='info-section__content-div'>
            <h3 className='info-section__content-div__title phone-title'>Phone:</h3>     
            <h4 className='info-section__content-div__title phone-value'>
                ({phoneNumber.slice(0,3)})
                {phoneNumber.slice(3,6)}-
                {phoneNumber.slice(6,10)}</h4>                     
        </div>
        <button className='info-section__modify-button phone-modify-button'>Change Phone #</button>
    </section>
    );
} 

function InfoSize({houseSize}) {
    return (
        <section className='info-section size'>
        <div className='info-section__content-div'>
            <h3 className='info-section__content-div__title size-title'>Household Size:</h3>
            <h4 className='info-section__content-div__content size-value'>{houseSize}</h4>
        </div>
        <button className='info-section__modify-button size-modify-button'>Change Household Size</button>
    </section>
    );
} 

function SingleRecipientPageContent({recipient}) {
    return (
        <div className='container'>
            <InfoNameHeader recipient={recipient} />
            <InfoDOB dateOfBirth={recipient.dateOfBirth} />
            <InfoPhone phoneNumber={recipient.phoneNumber} />
            <InfoAddress address={recipient.address} />
            <InfoSize houseSize={recipient.houseSize} />
            <InfoDelivery deliveryStatus={recipient.deliveryStatus} />
            <InfoOrderList orders={recipient.foodOrders} />
        </div>
        );
}

export default AppRouter