import React from 'react';
import InfoNameHeader from './hoh-info-page-components/hoh-info-name';
import InfoDOB from './hoh-info-page-components/hoh-info-dob';
import InfoPhone from './hoh-info-page-components/hoh-info-phone';
import InfoAddress from './hoh-info-page-components/hoh-info-address';
import InfoSize from './hoh-info-page-components/hoh-info-size';
import InfoDelivery from './hoh-info-page-components/hoh-info-delivery';
import InfoOrderList from './hoh-info-page-components/hoh-info-recent-orders';

const SingleRecipientPageContent = ({recipient}) => (
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

export default SingleRecipientPageContent;