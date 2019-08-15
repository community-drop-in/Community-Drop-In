import React from 'react';
import InfoNameHeader from './hoh-info-page-components/hoh-info-name';
import InfoDOB from './hoh-info-page-components/hoh-info-dob';
import InfoPhone from './hoh-info-page-components/hoh-info-phone';
import InfoAddress from './hoh-info-page-components/hoh-info-address';
import InfoSize from './hoh-info-page-components/hoh-info-size';
import InfoDelivery from './hoh-info-page-components/hoh-info-delivery';
import YesButton from './hoh-info-page-components/hoh-yes-button'
import NoButton from './hoh-info-page-components/hoh-no-button'

export default function SingleRecipientPageContent({ recipient, handleYesButtonClick, handleNoButtonClick }) {
    if (recipient !== undefined) {
        return (
            <div className='container'>
                <InfoNameHeader recipient={recipient} />
                <InfoDOB dateOfBirth={recipient.dateOfBirth} />
                <InfoPhone phoneNumber={recipient.phoneNumber} />
                <InfoAddress address={recipient.address} />
                <InfoSize houseSize={recipient.houseSize} />
                <InfoDelivery deliveryStatus={recipient.deliveryStatus} />
                <YesButton handleYesButtonClick={handleYesButtonClick}/>
                <NoButton handleNoButtonClick={handleNoButtonClick}/>
            </div>
        );
    }
}

