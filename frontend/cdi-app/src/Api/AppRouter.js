import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import SingleRecipientPageContent from '../components/hoh-info-page'
import HohTable from '../components/all-hoh-table'
import HohForm from '../components/hoh-form-page/hoh-form'

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
    function submitNewRecipient(model) { console.log(JSON.stringify(model)) }

    return (
        <Router>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} />} />
                <Route path='/hoh-form' render={() => <HohForm model={{
                    lastName: "",
                    phoneNumber: 0,
                    address: "",
                    deliveryStatus: null,
                    houseSize: 0,
                    dateOfBirth: "",
                    foodOrders: [],
                    firstName: ""
                }}
                    submitNewRecipient={submitNewRecipient} />} />
            </Switch>
        </Router>
    )
}

function getRootURL() {
    return 'http://localhost:8080/api/';
}

export default AppRouter