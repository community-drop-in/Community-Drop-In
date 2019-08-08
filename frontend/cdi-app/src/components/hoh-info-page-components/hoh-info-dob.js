import React from 'react';

const InfoDOB = ({dateOfBirth}) => (
    <section className='info-section dob'>
        <div className='info-section__content-div'>
            <h3 className='info-section__content-div__title dob-title'>DOB:</h3>
            <h4 className='info-section__content-div__content dob-value'>{dateOfBirth}</h4>
        </div>
    </section>
);

export default InfoDOB;