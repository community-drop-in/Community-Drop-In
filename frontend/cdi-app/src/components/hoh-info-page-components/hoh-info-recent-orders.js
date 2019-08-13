import React from 'react';
import InfoOrder from './hoh-info-order';

function makeOrderList(orders) {
    if(!orders) {
        return [];
    }
    return orders;
}

function InfoOrderList ({orders}) {
    return (
        <table className='order-table'>
            <thead className='order-table__head'>
                <tr className='order-table__title-row'>
                    <th className='order-table-title' colSpan='2'>ORDERS</th>
                </tr>
            </thead>
            <tbody className='order-table__body'>
                <tr>
                    <td className='size-td-label'>PEOPLE</td>
                    <td className='date-td-label'>DATE</td>
                </tr>
                {makeOrderList(orders).map(order => <InfoOrder order={order} />)}
            </tbody>
        </table>
    );
} 

export default InfoOrderList;