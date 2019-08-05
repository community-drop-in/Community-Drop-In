import React from 'react';

const InfoPage = ({ recipient }) => (
    <div className='container'>
        <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
    </div>
    );

export default InfoPage