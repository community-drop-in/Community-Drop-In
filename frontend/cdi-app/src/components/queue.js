import React from 'react';
import KitchenHeader from './kitchen-header'
import KitchenPage from './kitchen'

export default function Queue({orders}){
    return (
        <>
        <KitchenHeader/>
        {orders.map(order => <KitchenPage order={order}/>)}
        </>
    )
}