import React, { useEffect, useState } from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"
import SingleRecipientPageContent from '../components/hoh-info-page'
import HohTable from '../components/all-hoh-table'
import Queue from '../components/queue'

function AppRouter() {
    const [recipients, setRecipients] = useState([])
    const [recipient, setRecipient] = useState({})
    const [orders, setOrders] = useState([])
    const[newOrderInfo, setNewOrderInfo] = useState({})

    useEffect(() => {
        fetch(getRootURL() + 'recipients')
            .then(response => response.json())
            .then(recipients => setRecipients(recipients))
    }, [])

    useEffect(() => {
        fetch(getRootURL() + 'food-orders')
            .then(response => response.json())
            .then(orders => setOrders(orders))
    }, [])

    function handleRecipientClick(recipient) {
        setRecipient(recipient)
    }

    function handleOrderButtonClick(recipient){
        setNewOrderInfo({
            phoneNumber:recipient.phoneNumber,
            date: new Date().toISOString().slice(0,10)
        })
        fetch(
            getRootURL()+'food-orders', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newOrderInfo)
            }
        )
        .then(response => response.json())
    }

    return (
        <Router>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} handleOrderButtonClick={handleOrderButtonClick} />} />
                <Route path='/queue' render={() => <Queue orders={orders} />} />
            </Switch>
        </Router>
    )
}

function getRootURL() {
    return 'http://localhost:8080/api/';
}

export default AppRouter