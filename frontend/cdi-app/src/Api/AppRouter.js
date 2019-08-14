import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import SingleRecipientPageContent from '../components/hoh-info-page'
import HohTable from '../components/all-hoh-table'

function AppRouter() {
    const [recipients, setRecipients] = useState([]);
    const [recipient, setRecipient] = useState({});

    useEffect(() => {
        fetch(getRootURL() + 'recipients')
            .then(response => response.json())
            .then(recipients => setRecipients(recipients))
    }, [])

    function handleRecipientClick(recipient) {
        setRecipient(recipient)
    }

    return (
        <Router>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} />} />
            </Switch>
        </Router>
    )
}

function getRootURL() {
    return 'http://localhost:8080/api/';
}

export default AppRouter