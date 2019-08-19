import React from 'react';

export default function HohInfo ({ recipient, logOut, submitFoodOrder }) {
    function returnDeliveryStatus(deliveryStatus) {
        if (deliveryStatus) {
            return 'Yes'
        }
        return 'No'
    }
    return (
        <div className='container'>
            <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
            <h3 className='info-section__content-div__title dob-title'>DOB: {recipient.dateOfBirth}</h3>
            <h3 className='info-section__content-div__title phone-title'>Phone: {recipient.phoneNumber}</h3>
            <h3 className='info-section__content-div__title address-title'>Address: {recipient.address}</h3>
            <h3 className='info-section__content-div__title size-title'>Household Size: {recipient.houseSize}</h3>
            <h3 className='info-section__content-div__title delivery-status-title'>Delivery: {returnDeliveryStatus(recipient.deliveryStatus)}</h3>
            <h3 className='info-section__content-div__title'>Is this correct?</h3>
            <button onClick={() => {
                alert('Order sent! You have been logged out')
                submitFoodOrder(recipient.phoneNumber)
                logOut()
            }} className='give-food-button yes-button'>YES</button>
            <button onClick={() => {
                alert('Please try again or see a staff member for help.')
                logOut()
            }} className='give-food-button no-button'>NO</button>
        </div>
    );
}

