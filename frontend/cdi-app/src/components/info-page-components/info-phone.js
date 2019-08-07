import React from 'react';

const InfoPhone = ({recipient}) => (
    <section className='info-section phone'>
    <div className='info-section__content-div'>
        <h3 className='info-section__content-div__title phone-title'>Phone:</h3>     
        <h4 className='info-section__content-div__title phone-value'>
            ({recipient.phoneNumber.slice(0,3)})
            {recipient.phoneNumber.slice(3,6)}-
            {recipient.phoneNumber.slice(6,10)}</h4>                     
    </div>
    <button className='info-section__modify-button phone-modify-button'>Change Phone #</button>
</section>
);

export default InfoPhone;