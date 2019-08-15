import React, { useEffect, useState } from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"
import SingleRecipientPageContent from '../components/hoh-info-page'
import HohTable from '../components/all-hoh-table'
import HohForm from '../components/hoh-form-page/hoh-form'
import MainHeader from '../components/main-header'
import Queue from '../components/queue'
import HohLogin from '../components/hoh-login/hoh-login'

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

    async function handleRecipientClick(clickedRecipient) {
        // setRecipientPhoneNumber(clickedRecipient.phoneNumber)
        await setRecipient(clickedRecipient)
        console.log(recipient)
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

    function selectRecipientByPhone(recipientPhoneNumber) {
        recipients.filter( async (foundRecipient) => {
            if(foundRecipient.phoneNumber == recipientPhoneNumber){
                console.log(foundRecipient)
                await setRecipient(foundRecipient)
                console.log(recipient)
            }
        })
    }

    function renderSingleHoh(){
            console.log(recipient)
        if(recipient.lastName !== undefined)
            return <Route path='/single-hoh' render={() => <SingleRecipientPageContent recipient={recipient} handleOrderButtonClick={handleOrderButtonClick} />} />
    }

    return (
        <Router>
            <MainHeader/>
            <Switch>
                <Route exact path='/' render={() => <HohTable recipients={recipients} handleRecipientClick={handleRecipientClick} />} />
                <Route path='/queue' render={() => <Queue orders={orders} />} />
                {renderSingleHoh()}
                
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
                <Route path='/hoh-login' render={() => <HohLogin selectRecipientByPhone={selectRecipientByPhone}/>}/>
            </Switch>
        </Router>
    )
    
}

function getRootURL() {
    return 'http://localhost:8080/api/';
}


export default AppRouter