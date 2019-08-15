import React, { useEffect, useState } from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"
import SingleRecipientPageContent from '../components/hoh-info-page'
import HohTable from '../components/all-hoh-table'
import HohForm from '../components/hoh-form-page/hoh-form'
import MainHeader from '../components/main-header'
import Queue from '../components/queue'

function AppRouter() {
    const [recipients, setRecipients] = useState([])
    const [recipient, setRecipient] = useState({})
    const [recipientPhoneNumber, setRecipientPhoneNumber] = useState()
    const [recipientSelector, setRecipientSelector] = useState()
    const [orders, setOrders] = useState([])

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
    

    function handleRecipientClick(clickedRecipient) {
        // setRecipientPhoneNumber(clickedRecipient.phoneNumber)
        setRecipient(clickedRecipient)
    }
    function submitNewRecipient(model) { 
        fetch(
            getRootURL()+'recipients', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(model)
            }
        )
        .then(response => response.json())
        console.log(recipients)
    }

    function handleOrderButtonClick(clickedRecipient){
        console.log('clicked recipient',clickedRecipient)
        fetch(
            getRootURL()+'food-orders', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    phoneNumber:clickedRecipient.phoneNumber,
                    date: new Date().toISOString().slice(0,10)
                })
            }
        )
        .then(response => response.json())
        .then(recipientList => setRecipients(recipientList))
    }

    function selectRecipient() {
        return recipients.filter(recipient => {return recipient.phoneNumber == recipientPhoneNumber})
    }

    return (
        <Router>
            <MainHeader/>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/queue' render={() => <Queue orders={orders} />} />
                <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} handleOrderButtonClick={handleOrderButtonClick} />} />
                {/* <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={selectRecipient()} handleOrderButtonClick={handleOrderButtonClick} />} /> */}
                <Route path='/hoh-form' render={() => <HohForm model={{
                    lastName: "",
                    phoneNumber: 0,
                    address: "",
                    deliveryStatus: false,
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