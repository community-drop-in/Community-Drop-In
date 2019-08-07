import React from 'react';
import InfoH2 from './info-page-components/info-h2';
import InfoDOB from './info-page-components/info-dob';
import InfoPhone from './info-page-components/info-phone';
import InfoAddress from './info-page-components/info-address';
import InfoSize from './info-page-components/info-size';
import InfoDelivery from './info-page-components/info-delivery';

const InfoPage = ({ recipient }) => (
    <div className='container'>
        <InfoH2 recipient={recipient} />
        <InfoDOB recipient={recipient} />
        <InfoPhone recipient={recipient} />
        <InfoAddress recipient={recipient} />
        <InfoSize recipient={recipient} />
        <InfoDelivery recipient={recipient} />
    </div>
    );

export default InfoPage