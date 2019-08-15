import React from 'react'

export default function NoButton({handleNoButtonClick, recipient}) {
    return (
        <>
        <button onClick={
            (e) => {
            e.preventDefault()
            handleNoButtonClick(recipient)}
        }
        className='no-button'>No</button>
        </>
    )
}