import React from 'react';
import InfoOrder from './hoh-info-order';

function InfoOrderList({ orders }) {
    return (
        <article className='order-article'>
            <ul className='order-table__title-row'>
                <li className='order-article-title' colSpan='2'>ORDERS</li>
            </ul>
            <ul>
                <li className='size-li-label'>PEOPLE</li>
                <li className='date-li-label'>DATE</li>
            </ul>
                {orders.map(order => <InfoOrder order={order} />)}
        </article>
    );
}

export default InfoOrderList;