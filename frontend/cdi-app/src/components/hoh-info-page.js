import React from 'react';
import InfoNameHeader from './hoh-info-page-components/hoh-info-name';
import InfoDOB from './hoh-info-page-components/hoh-info-dob';
import InfoPhone from './hoh-info-page-components/hoh-info-phone';
import InfoAddress from './hoh-info-page-components/hoh-info-address';
import InfoSize from './hoh-info-page-components/hoh-info-size';
import InfoDelivery from './hoh-info-page-components/hoh-info-delivery';
import InfoOrderList from './hoh-info-page-components/hoh-info-recent-orders';
import OrderButton from './hoh-info-page-components/hoh-submit-button';

export default function SingleRecipientPageContent({ recipient, handleOrderButtonClick }) {
    if (recipient !== undefined) {
        return (
            <div className='container'>
                <InfoNameHeader recipient={recipient} />
                <InfoDOB dateOfBirth={recipient.dateOfBirth} />
                <InfoPhone phoneNumber={recipient.phoneNumber} />
                <InfoAddress address={recipient.address} />
                <InfoSize houseSize={recipient.houseSize} />
                <InfoDelivery deliveryStatus={recipient.deliveryStatus} />
                <OrderButton handleOrderButtonClick={handleOrderButtonClick} recipient={recipient} />
                <InfoOrderList orders={recipient.foodOrders} />
            </div>
        );
    }
}

