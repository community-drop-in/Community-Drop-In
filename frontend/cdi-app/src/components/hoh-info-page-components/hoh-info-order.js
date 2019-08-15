import React from 'react';

function InfoOrder({ order }) {
    return (
        <ul className='order-row'>
            <li className='size-li'>{order.size}</li>
            <li className='date-li'>{order.date}</li>
        </ul>
    );
}

export default InfoOrder;