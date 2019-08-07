import React from 'react';
import ReactDOM from 'react-dom';
import KitchenPage from './kitchen';

const order = {
    size:3,
    date: '2019-08-02',
    hohFirstName: "John",
    hohLastName: "Doe",
    
};

describe('Kitchen Page Component', () => {
    let entryPoint;
     
    beforeEach(() => {
        entryPoint = document.createElement('div');
        ReactDOM.render(<KitchenPage order={order} />, entryPoint);
    });
    
        describe('div testing', () => {
            test('render div', () => {
                expect(entryPoint.querySelector('.kitchen-sub-header') instanceof HTMLDivElement).toBeTruthy();
            })
        });
        describe('kitchen content test', () => {
            test('render h2 name of the order', () =>{
                expect(entryPoint.querySelector('.order-kitchen-name').tagName).toMatch('H2');
                expect(entryPoint.querySelector('.order-kitchen-name').textContent).toMatch("John Doe");
             });
             test('render h2 size of the order', () =>{
                expect(entryPoint.querySelector('.order-house-size').tagName).toMatch('H2');
                expect(entryPoint.querySelector('.order-house-size').textContent).toMatch("3");
             });
             test('render h2 date of the order', () =>{
                expect(entryPoint.querySelector('.order-date').tagName).toMatch('H2');
                expect(entryPoint.querySelector('.order-date').textContent).toMatch("2019-08-02");
             });
            
        });
    })
 