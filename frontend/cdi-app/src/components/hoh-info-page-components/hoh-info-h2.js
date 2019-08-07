import React from 'react';

const InfoH2 = ({ recipient }) => (
    <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
);

export default InfoH2;