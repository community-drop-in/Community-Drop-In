import React from 'react';

function InfoAddress({ address }) {
    return (
        <section className='info-section address'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title address-title'>Address:</h3>
                <h4 className='info-section__content-div__content address-value'>{address}</h4>
            </div>
            <button className='info-section__modify-button address-modify-button'>Change Address</button>
        </section>
    );
}

export default InfoAddress;