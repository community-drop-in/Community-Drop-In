import React from 'react';
import ReactDOM from 'react-dom';
import InfoPage from './info-page';

const recipient = {
    firstName: "John",
    lastName: "Doe",
    address: "123 Anywhere Street",
    phoneNumber: "6145551212",
    deliveryStatus: false,
    houseSize: 4,
    dateOfBirth: "1995-10-08"
};

describe('Info Page Component', () => {
    let entryPoint;

    beforeEach(() => {
        entryPoint = document.createElement('div');
        ReactDOM.render(<InfoPage recipient={recipient} />, entryPoint);
    });

    test('render container', () =>{
        expect(entryPoint.querySelector('.container') instanceof HTMLDivElement).toBeTruthy();
    });

    test('render h2 with class info-title and text firstName lastName ', () => {
        expect(entryPoint.querySelector('.info-title').tagName).toMatch('H2');
        expect(entryPoint.querySelector('.info-title').textContent).toMatch('John Doe');
    });

    test('info-section phone should be a section', () => {
        expect(entryPoint.querySelector('.info-section').tagName).toMatch('SECTION');
        expect(entryPoint.querySelector('.dob').tagName).toMatch('SECTION');
    });

    test('info-section phone should be a div', () => {

    })
});