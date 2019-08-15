import React, { useEffect, useState } from 'react'
import './App.css';

import HohInfoPage from '../components/hoh-info/hoh-info'
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
    fetch('http://localhost:8080/api/recipients', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(model)
    }
    )
      .then(response => response.json())
    setRoute('user')
    updateRecipient(model.phoneNumber)
    console.log(recipient)
    toggleLogin()
  }

  function updateRecipient (recipientPhoneNumber) {
    const foundRecipient = recipients.filter(mappedRecipient => recipientPhoneNumber == mappedRecipient.phoneNumber)[0]
    if(foundRecipient){
      setRecipient(foundRecipient)
    }
  }

  function updateLogin (recipientPhoneNumber) {
    const foundRecipient = recipients.filter(mappedRecipient => recipientPhoneNumber == mappedRecipient.phoneNumber)[0]
    if(foundRecipient){
      setIsLoggedIn(!isLoggedIn)
    }
  }

  function toggleLogin(){
    setIsLoggedIn(!isLoggedIn)
  }

  return (
    <>
      <MainHeader isLoggedIn={isLoggedIn} setRoute={setRoute} />

      {!isLoggedIn && <HohLogin updateLogin={updateLogin} updateRecipient={updateRecipient} />}
      {(isLoggedIn && route === 'user') && <HohInfoPage toggleLogin={toggleLogin} recipient={recipient} />}
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
        submitNewRecipient={submitNewRecipient} />}
    </>
  )

}

export default App;
