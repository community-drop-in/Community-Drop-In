import React from 'react';
import InfoOrder from './hoh-info-order';

const InfoOrderList = ({orders}) => (
    <table className='order-table'>
        <thead className='order-table__head'>
            
        </thead>
        <tbody className='order-table__body'>

            {orders.map(order => <InfoOrder order={order} />)}
        </tbody>
    </table>
);

export default InfoOrderList;