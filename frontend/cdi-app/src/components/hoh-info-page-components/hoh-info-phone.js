import React from 'react';

function InfoPhone({phoneNumber}) {
    return (
        <section className='info-section phone'>
        <div className='info-section__content-div'>
            <h3 className='info-section__content-div__title phone-title'>Phone:</h3>     
            <h4 className='info-section__content-div__title phone-value'>
                ({phoneNumber.slice(0,3)})
                {phoneNumber.slice(3,6)}-
                {phoneNumber.slice(6,10)}</h4>                     
        </div>
        <button className='info-section__modify-button phone-modify-button'>Change Phone #</button>
    </section>
    );
} 

export default InfoPhone;