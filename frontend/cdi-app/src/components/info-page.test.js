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

    describe('renders and header', () => {
        test('render container', () =>{
            expect(entryPoint.querySelector('.container') instanceof HTMLDivElement).toBeTruthy();
        });
    
        test('render h2 with class info-title and text firstName lastName ', () => {
            expect(entryPoint.querySelector('.info-title').tagName).toMatch('H2');
            expect(entryPoint.querySelector('.info-title').textContent).toMatch('John Doe');
        });
    });

    describe('info-section & modify-button basic testing', () => {
        test('info-section should be a section', () => {
            expect(entryPoint.querySelector('.info-section').tagName).toMatch('SECTION');
            expect(entryPoint.querySelector('.dob').tagName).toMatch('SECTION');
        });
    
        test('info-section__content-div should be a div', () => {
            expect(entryPoint.querySelector('.info-section__content-div').tagName).toMatch('DIV');
        });
    
        test('info-section__content-div__title should be an H3 and contain "Phone:" ', () => {
            expect(entryPoint.querySelector('.info-section__content-div__title').tagName).toMatch('H3');
        });
    
        test('info-section__content-div__content should be an h4', () => {
            expect(entryPoint.querySelector('.info-section__content-div__content').tagName).toMatch('H4');
        });
        
        test('modify-button should be a button', () => {
            expect(entryPoint.querySelector('.info-section__modify-button').tagName).toMatch('BUTTON');
        }); 
    });

    describe('dob content tests', () => {
        test('dob-title should have text "DOB:"', () => {
            expect(entryPoint.querySelector('.dob-title').textContent).toMatch('DOB:');
        });
        
        test('dob-value should have text of the date 1995-10-08', () => {
            expect(entryPoint.querySelector('.dob-value').textContent).toMatch('1995-10-08');
        });
    });

    describe('phone number content tests', () => {
        test('phone-title should have text Phone:', () => {
            expect(entryPoint.querySelector('.phone-title').textContent).toMatch('Phone:');
        });
        
        test('phone-value should have number of (614)555-1212', () => {
            expect(entryPoint.querySelector('.phone-value').textContent).toMatch('(614)555-1212');
        });
    
        test('phone-modify-button should have text "Change Phone #"', () => {
            expect(entryPoint.querySelector('.phone-modify-button').textContent).toMatch('Change Phone #');
        });
    });

    describe('address content tests', () => {
        test('address-title should have text Address:', () => {
            expect(entryPoint.querySelector('.address-title').textContent).toMatch('Address:');
        });
    
        test('address-value should have text "123 Anywhere Street"', () => {
            expect(entryPoint.querySelector('.address-value').textContent).toMatch('123 Anywhere Street');
        });
    
        test('address-modify-button should have text "Change Address"', () => {
            expect(entryPoint.querySelector('.address-modify-button').textContent).toMatch('Change Address');
        });
    });

    describe('household size content tests', () => {
        test('size-title should have text "Household Size:', () => {
            expect(entryPoint.querySelector('.size-title').textContent).toMatch('Household Size:');
        });
    
        test('size-value should have text "4"', () => {
            expect(entryPoint.querySelector('.size-value').textContent).toMatch('4');
        });
    
        test('size-modify-button should have text "Change Household Size"', () => {
            expect(entryPoint.querySelector('.size-modify-button').textContent).toMatch('Change Household Size');
        });
    });



});