import React, { useEffect, useState } from 'react'
import './App.css';

import HohInfoPage from '../components/hoh-info/hoh-info'
import HohForm from '../components/hoh-form-page/hoh-form'
import MainHeader from '../components/main-header/main-header'
import HohLogin from '../components/hoh-login/hoh-login'

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
    console.log(recipients)
  }

  function updateRecipient (recipientPhoneNumber) {
    const recipient = recipients.filter(recipient => recipientPhoneNumber === recipient.phonNumber)[0]
    setRecipient(recipient)
  }

  function updateLogin () {
    setIsLoggedIn(!isLoggedIn)
  }

  return (
    <>
      <MainHeader isLoggedIn={isLoggedIn} setRoute={setRoute} />

      {!isLoggedIn && <HohLogin updateLogin={updateLogin} updateRecipient={updateRecipient} />}
      {(isLoggedIn && route === 'user') && <HohInfoPage updateLogin={updateLogin} recipient={recipient} />}
      {(isLoggedIn && route === 'form') && <HohForm model={{
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
