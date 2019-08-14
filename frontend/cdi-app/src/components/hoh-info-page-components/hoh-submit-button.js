import React from 'react';

export default function OrderButton({handleOrderButtonClick, recipient}) {
    return (
        <>
        <button onClick={
            (e) => {
            e.preventDefault()
            handleOrderButtonClick(recipient)}
        }
        className='give-food-button'>SUBMIT ORDER</button>
        </>
    )
}