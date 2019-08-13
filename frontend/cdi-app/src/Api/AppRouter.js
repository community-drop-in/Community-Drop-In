import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function AppRouter() {
    const [recipients, setRecipients] = useState([]);
    const [recipient, setRecipient] = useState({});
    const [showAllRecipients, setShowAllRecipients] = useState(true);


    useEffect(() => {
        fetch(getRootURL() + 'recipients')
            .then(response => response.json())
            .then(recipients => setRecipients(recipients))
    }, [])

    function handleRecipientClick(recipient) {
        setRecipient(recipient)
    }

    return (
        <Router>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} />} />
            </Switch>
        </Router>
    )
}


function DeliveryStatusText(deliveryStatus) {
    if (deliveryStatus === true) {
        return 'Yes';
    }
    return 'No';
}

function getRootURL() {
    return 'http://localhost:8080/api/';
}

function HohTable({ recipients, handleRecipientClick }) {
    return (
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
    )
}

function HohTableRow({ recipient, handleRecipientClick }) {
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

function InfoAddress({ address }) {
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

function InfoDelivery({ deliveryStatus }) {
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

function InfoDOB({ dateOfBirth }) {
    return (
        <section className='info-section dob'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title dob-title'>DOB:</h3>
                <h4 className='info-section__content-div__content dob-value'>{dateOfBirth}</h4>
            </div>
        </section>
    );
}

function InfoNameHeader({ recipient }) {
    return (
        <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
    );
}

function InfoOrder({ order }) {
    return (
        <ul className='order-row'>
            <li className='size-li'>{order.size}</li>
            <li className='date-li'>{order.date}</li>
        </ul>
    );
}

function InfoOrderList({ orders }) {
    return (
        <article className='order-article'>
            <ul className='order-table__title-row'>
                <li className='order-article-title' colSpan='2'>ORDERS</li>
            </ul>
            <ul>
                <li className='size-li-label'>PEOPLE</li>
                <li className='date-li-label'>DATE</li>
            </ul>
            console.log(orders);
                {orders.map(order => <InfoOrder order={order} />)}
        </article>
    );
}

function InfoPhone({ phoneNumber }) {
    return (
        <section className='info-section phone'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title phone-title'>Phone:</h3>
                <h4 className='info-section__content-div__title phone-value'>
                    {InfoPhoneParse(phoneNumber)}</h4>
            </div>
            <button className='info-section__modify-button phone-modify-button'>Change Phone #</button>
        </section>
    );
}

function InfoPhoneParse({ phoneNumber }) {
    if (phoneNumber !== undefined) {
        return (
            '(' + phoneNumber.toString().slice(0, 3) + ') ' +
            phoneNumber.toString().slice(3, 6) + '-' +
            phoneNumber.toString().slice(6, 10)
        )
    }
}

function InfoSize({ houseSize }) {
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

function SingleRecipientPageContent({ recipient }) {
    if (recipient !== undefined) {
        return (
            <div className='container'>
                <InfoNameHeader recipient={recipient} />
                <InfoDOB dateOfBirth={recipient.dateOfBirth} />
                {/* <InfoPhone phoneNumber={recipient.phoneNumber} /> */}
                <InfoAddress address={recipient.address} />
                <InfoSize houseSize={recipient.houseSize} />
                <InfoDelivery deliveryStatus={recipient.deliveryStatus} />
                {/* <InfoOrderList orders={recipient.foodOrders} /> */}
            </div>
        );
    }
}

export default AppRouter