import React, { useEffect, useState } from 'react'
import './App.css';

import HohInfo from '../components/hoh-info/hoh-info'
import HohForm from '../components/hoh-form-page/hoh-form'
import MainHeader from '../components/main-header/main-header'
import HohLogin from '../components/hoh-login/hoh-login'
import { conditionalExpression } from '@babel/types';

function App () {
  const [recipients, setRecipients] = useState([])
  const [recipient, setRecipient] = useState({})
  const [isLoggedIn, setIsLoggedIn] = useState(false)
  const [route, setRoute] = useState('user')

  useEffect(() => {
    fetch('http://localhost:8080/api/recipients')
      .then(response => response.json())
      .then(recipients => setRecipients(recipients))
  }, [])

  function submitNewRecipient (model) {
    if(noNullValuesInNewRecipient(model)) {
      alert('Welcome!')
      fetch('http://localhost:8080/api/recipients', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(model)
      }
      )
        .then(response => response.json())
        .then(recipients => setRecipients(recipients))
      setRoute('user')
      updateRecipient(model.phoneNumber)
    }
  }

  function updateRecipient (recipientPhoneNumber) {
    const foundRecipient = recipients.filter(mappedRecipient => recipientPhoneNumber == mappedRecipient.phoneNumber)[0]
    if(foundRecipient){
      setRecipient(foundRecipient)
    }
  }

  function logInWithPhone (recipientPhoneNumber) {
    const foundRecipient = recipients.filter(mappedRecipient => recipientPhoneNumber == mappedRecipient.phoneNumber)[0]
    if(foundRecipient){
      logIn()
    }
  }

  function logIn(){
    setIsLoggedIn(true)
  }

  function logOut(){
    setIsLoggedIn(false)
  }

  function noNullValuesInNewRecipient(model) {
    return (
      model.firstName && model.lastName && model.dateOfBirth && model.address && model.phoneNumber && model.houseSize
    )
  }

  return (
    <>
      <MainHeader />

      {(!isLoggedIn && route === 'user') && <HohLogin updateLogin={logInWithPhone} updateRecipient={updateRecipient} setRoute={setRoute} />}
      {(isLoggedIn && route === 'user') && <HohInfo logOut={logOut} recipient={recipient} />}
      {(!isLoggedIn && route === 'form') && <HohForm model={{
        lastName: "",
        phoneNumber: 0,
        address: "",
        deliveryStatus: false,
        houseSize: 0,
        dateOfBirth: "",
        foodOrders: [],
        firstName: ""
      }}
        submitNewRecipient={submitNewRecipient}
        goBackClick={setRoute}
        />}
    </>
  )

}

export default App;
