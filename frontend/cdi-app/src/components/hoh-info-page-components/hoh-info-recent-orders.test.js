import React from 'react';
import ReactDOM from 'react-dom';
import InfoOrderList from './hoh-info-recent-orders';

const orders = [
    {
        id: 6,
        size: 4,
        date: "2019-08-09",
        hohFirstName: "Joe",
        hohLastName: "Schmmo"
    },
    {
        id: 5,
        size: 3,
        date: "2019-08-02",
        hohFirstName: "Joe",
        hohLastName: "Schmmo"
    }
];

let entryPoint;

beforeEach(() => {
    entryPoint = document.createElement('div');
    ReactDOM.render(<InfoOrderList orders={orders} />, entryPoint);
});

test('should render table', () => {
    expect(entryPoint.querySelector('.order-table') instanceof HTMLTableElement).toBeTruthy();
    expect(entryPoint.querySelector('.order-table__head').tagName).toMatch('THEAD');
    expect(entryPoint.querySelector('.order-table__body').tagName).toMatch('TBODY');
    expect(entryPoint.querySelector('.order-row').tagName).toMatch('TR');
});

test('table should contain Joe Schmmo and John Doe', () => {
    expect(entryPoint.querySelectorAll('.date-td')[0].textContent).toMatch('2019-08-09');
    expect(entryPoint.querySelectorAll('.date-td')[1].textContent).toMatch('2019-08-02');
});