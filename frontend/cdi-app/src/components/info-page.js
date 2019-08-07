import React from 'react';

const InfoPage = ({ recipient }) => (
    <div className='container'>
        <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
        <section className='info-section dob'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title dob-title'>DOB:</h3>
                <h4 className='info-section__content-div__content dob-value'>{recipient.dateOfBirth}</h4>
            </div>
        </section>
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
        <section className='info-section address'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title address-title'>Address:</h3>
                <h4 className='info-section__content-div__content address-value'>{recipient.address}</h4>
            </div>
            <button className='info-section__button address-modify-button'>Change Address</button>
        </section>
        <section className='info-section size'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title size-title'>Household Size:</h3>
                <h4 className='info-section__content-div__content size-value'>{recipient.houseSize}</h4>
            </div>
            <button className='info-section__modify-button size-modify-button'>Change Household Size</button>
        </section>
        <section className='info-section delivery-status'>
            <div className='info-section__content-div'>
                <h3 className='info-section__content-div__title delivery-status-title'>Delivery:</h3>
                <h4 className='info-section__content-div__content'>Yes</h4>
            </div>
            <button className='info-section__modify-button'>Remove Delivery</button>
        </section>
    </div>
    );

export default InfoPage