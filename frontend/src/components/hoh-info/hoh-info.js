import React from 'react';

export default function SingleRecipientPageContent ({ recipient, handleOrderButtonClick }) {
    return (
        <div className='container'>
            <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
            <h3 className='info-section__content-div__title dob-title'>DOB: {recipient.dateOfBirth}</h3>
            <h3 className='info-section__content-div__title phone-title'>Phone: {SingleRecipientPageContent.phoneNumber}</h3>
            <h3 className='info-section__content-div__title address-title'>Address: {recipient.address}</h3>
            <h3 className='info-section__content-div__title size-title'>Household Size: {SingleRecipientPageContent.houseSize}</h3>
            <h3 className='info-section__content-div__title delivery-status-title'>Delivery: {recipient.deliveryStatus}</h3>
            <button onClick={() => handleOrderButtonClick(recipient)} className='give-food-button'>SUBMIT ORDER</button>
        </div>
    );
}

