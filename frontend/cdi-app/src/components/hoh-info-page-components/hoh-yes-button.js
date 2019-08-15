import React from 'react';

export default function YesButton({handleYesButtonClick, recipient}) {
    return (
        <>
        <button onClick={
            (e) => {
            e.preventDefault()
            handleYesButtonClick(recipient)}
        }
        className='yes-button'>Yes</button>
        </>
    )
}