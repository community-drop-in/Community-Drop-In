import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"

export default function YesButton({handleYesButtonClick, recipient}) {
    return (
        <>
        <Link to='/login' onClick={
            () => {
                handleYesButtonClick(recipient)
            }
        }
        className='yes-button'>Yes</Link>
        </>
    )
}