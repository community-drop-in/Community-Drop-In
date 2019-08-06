import React from 'react'
import ReactDOM from 'react-dom'

import Finder from './finder'

const recipients = [
    {
    id: 1,
    lastName: "Schmmo",
    phoneNumber: 3304529259,
    address: "1770 Pennsylvania Ave",
    deliveryStatus: true,
    houseSize: 3,
    // datesReceived: [],
    firstName: "Joe",
    dateofBirth: "1995-10-07"
    }
]

describe('Finder component', () => {
    let entryPoint

    beforeEach(() => {
        entryPoint = document.createElement('div');
        ReactDOM.render(<Finder recipient={recipient} />, entryPoint);
    });

    test('renders', () => {
        expect(entryPoint.querySelector('.finder') instanceof HTMLElement).toBeTruthy();
    });
    test('renders th element with id of 1', () => {
        expect(entryPoint.querySelector('.body__id').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.body__id').textContent).toMatch('1');
    });
    test('renders th element with lastname of Schmmo', () => {
        expect(entryPoint.querySelector('.body__lastname').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.body__lastname').textContent).toMatch('Schmmo');
    });
    test('renders th element with phone number of 3304529259', () => {
        expect(entryPoint.querySelector('.body__phone').tagName).toMatch('TH');
        expect(entryPoint.querySelector('.body__phone').textContent).toMatch('3304529259');
    });
});