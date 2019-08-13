import React from 'react';

function InfoOrder({order}) {
    return (
        <tr className='order-row'>
            <td className='size-td'>{order.size}</td>
            <td className='date-td'>{order.date}</td>
        </tr>
    );    
} 

export default InfoOrder;