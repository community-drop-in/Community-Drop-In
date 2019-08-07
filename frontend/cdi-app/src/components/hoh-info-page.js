import React from 'react';
import InfoNameHeader from './hoh-info-page-components/hoh-info-name';
import InfoDOB from './hoh-info-page-components/hoh-info-dob';
import InfoPhone from './hoh-info-page-components/hoh-info-phone';
import InfoAddress from './hoh-info-page-components/hoh-info-address';
import InfoSize from './hoh-info-page-components/hoh-info-size';
import InfoDelivery from './hoh-info-page-components/hoh-info-delivery';
import InfoOrders from './hoh-info-page-components/hoh-info-recent-orders';

const SingleRecipientPageContent = ({ recipient }) => (
    <div className='container'>
        <InfoNameHeader recipient={recipient} />
        <InfoDOB recipient={recipient} />
        <InfoPhone recipient={recipient} />
        <InfoAddress recipient={recipient} />
        <InfoSize recipient={recipient} />
        <InfoDelivery recipient={recipient} />
    </div>
    );

export default SingleRecipientPageContent;