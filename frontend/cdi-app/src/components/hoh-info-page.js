import React from 'react';
import InfoH2 from './hoh-info-page-components/hoh-info-h2';
import InfoDOB from './hoh-info-page-components/hoh-info-dob';
import InfoPhone from './hoh-info-page-components/hoh-info-phone';
import InfoAddress from './hoh-info-page-components/hoh-info-address';
import InfoSize from './hoh-info-page-components/hoh-info-size';
import InfoDelivery from './hoh-info-page-components/hoh-info-delivery';

const SingleRecipientPageContent = ({ recipient }) => (
    <div className='container'>
        <InfoH2 recipient={recipient} />
        <InfoDOB recipient={recipient} />
        <InfoPhone recipient={recipient} />
        <InfoAddress recipient={recipient} />
        <InfoSize recipient={recipient} />
        <InfoDelivery recipient={recipient} />
    </div>
    );

export default SingleRecipientPageContent;