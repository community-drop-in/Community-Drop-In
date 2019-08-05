import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Api from './Api/Api'
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.css';
// import Counter from './components/counter.jsx'
import Finder from './components/finder.js'

const testRecipient = {
    id: 1,
    lastName: "Schmmo",
    phoneNumber: 3304529259,
    address: "1770 Pennsylvania Ave",
    deliveryStatus: true,
    houseSize: 3,
    // datesReceived: [],
    firstName: "Joe",
    dateOfBirth: "1995-10-07"
}
console.log(testRecipient)

const apiRecipient = Api().getRequest(Api().getRootURL()+'recipients', recipients => {
    ReactDOM.render(<Finder recipients={recipients} />, document.getElementById('root'));
    recipients.forEach(recipient =>{
        console.log(recipient)
        console.log(recipient.id)
        console.log(recipient.lastName)
        console.log(recipient.phoneNumber)
        console.log(recipient.address)
    })
})

// ReactDOM.render(<Counter />, document.getElementById('root'));
// ReactDOM.render(<Finder recipient={testRecipient} />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
