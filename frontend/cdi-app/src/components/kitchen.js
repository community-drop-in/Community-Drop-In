import React from 'react';
const KitchenPage = ({ order }) => (
    <div className ='kitchen-sub-header'>
        <h2 className='order-kitchen-name'>{order.hohFirstName} {order.hohLastName}</h2>
        <h2 className='order-house-size'>{order.size}</h2>
        <h2 className='order-date'>{order.date}</h2>
    </div>
)

export default KitchenPage;