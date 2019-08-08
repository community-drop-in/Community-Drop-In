import React from 'react';
import InfoOrder from './hoh-info-order';

const InfoOrderList = ({orders}) => (
    <table className='order-table'>
        <thead className='order-table__head'>
        <th className='order-table-title' colSpan='2'>ORDERS</th>
        </thead>
        <tbody className='order-table__body'>
            <tr>
                <td className='size-td-label'>PEOPLE</td>
                <td className='date-td-label'>DATE</td>
            </tr>
            {orders.map(order => <InfoOrder order={order} />)}
        </tbody>
    </table>
);

export default InfoOrderList;