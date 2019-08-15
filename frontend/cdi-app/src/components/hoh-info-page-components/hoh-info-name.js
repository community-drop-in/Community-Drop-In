import React from 'react';

function InfoNameHeader({ recipient }) {
    return (
        <h2 className="info-title">{recipient.firstName} {recipient.lastName}</h2>
    );
}

export default InfoNameHeader;