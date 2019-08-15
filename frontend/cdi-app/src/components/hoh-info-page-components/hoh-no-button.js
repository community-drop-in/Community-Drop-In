import React from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"

export default function NoButton({handleNoButtonClick, recipient}) {
    return (
        <>
        <Link to='' onClick={
            () => {
                handleNoButtonClick(recipient)
            }
        }
        className='no-button'>No</Link>
        </>
    )
}