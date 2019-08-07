import React from 'react';

const InfoNameHeader = ({ recipient }) => (
    <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
);

export default InfoNameHeader;