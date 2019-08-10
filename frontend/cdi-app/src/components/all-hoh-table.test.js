import React from 'react'
import ReactDOM from 'react-dom'
import AllHohTable from './all-hoh-table'

let entryPoint;

const recipients =[
{
    firstName: "Joe",
    lastName: "Schmmo",
    address: "123 Anywhere Street",
    phoneNumber: "6145551212",
    deliveryStatus: false,
    houseSize: 4,
    dateOfBirth: "1995-10-08",
    foodOrders: [
        {
            id: 5,
            size: 3,
            date: "2019-08-02",
            hohFirstName: "Joe",
            hohLastName: "Schmmo"
        },
        {
            id: 6,
            size: 4,
            date: "2019-08-09",
            hohFirstName: "Joe",
            hohLastName: "Schmmo"
        }
    ],
}
]
    

beforeEach(() => {
entryPoint = document.createElement('div');
ReactDOM.render(<AllHohTable recipients = {recipients} />, entryPoint);

});
describe('all hoh table test', () => {
    test('renders table', () => {
        expect(entryPoint.querySelector('.results-table').tagName).toMatch('TABLE');
    })
    test('render first table row', () => {
        expect(entryPoint.querySelector('.results-table__body').tagName).toMatch('TBODY');
        expect(entryPoint.querySelector('.results-table__head').tagName).toMatch('TR');
        expect(entryPoint.querySelector('.head__firstname').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__lastname').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__dob').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__phone').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__address').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__household').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__delivery').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.head__eligible').tagName).toMatch('TH');

    })
    test('first table row text', () => {
        expect(entryPoint.querySelector('.head__firstname').textContent).toMatch('First Name');
        expect(entryPoint.querySelector('.head__lastname').textContent).toMatch('Last Name');
        expect(entryPoint.querySelector('.head__dob').textContent).toMatch('DOB');
        expect(entryPoint.querySelector('.head__phone').textContent).toMatch('Phone');
        expect(entryPoint.querySelector('.head__address').textContent).toMatch('Address');
        expect(entryPoint.querySelector('.head__household').textContent).toMatch('Household');
        expect(entryPoint.querySelector('.head__delivery').textContent).toMatch('Delivery');
        expect(entryPoint.querySelector('.head__eligible').textContent).toMatch('Eligible');

    })
    test('single table row', () => {
        expect(entryPoint.querySelector('.recipient-first-name').textContent).toMatch('Joe');
        expect(entryPoint.querySelector('.recipient-last-name').textContent).toMatch('Schmmo');
        expect(entryPoint.querySelector('.recipient-dob').textContent).toMatch('1995-10-08');
        expect(entryPoint.querySelector('.recipient-phone-number').textContent).toMatch('(614)555-1212');
        expect(entryPoint.querySelector('.recipient-address').textContent).toMatch('123 Anywhere Street');
        expect(entryPoint.querySelector('.recipient-household').textContent).toMatch('4');
        expect(entryPoint.querySelector('.recipient-delivery').textContent).toMatch('No');
        expect(entryPoint.querySelector('.recipient-eligible').textContent).toMatch('');
    });








})



