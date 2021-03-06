import React from 'react';

function DeliveryStatusText(deliveryStatus) {
    return deliveryStatus ? 'Yes' : 'No'
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

export default InfoDelivery;