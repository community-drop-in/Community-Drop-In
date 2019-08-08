import React from 'react';
import ReactDOM from 'react-dom';
import InfoOrder from './hoh-info-order';

const order = {
    id: 5,
    size: 3,
    date: "2019-08-02",
    hohFirstName: "Joe",
    hohLastName: "Schmmo"
};

let entryPoint;

beforeEach(() => {
    entryPoint = document.createElement('tbody');
    ReactDOM.render(<InfoOrder order={order} />, entryPoint);
});

test('should render table row containing size and date', () => {
    expect(entryPoint.querySelector('.order-row').tagName).toMatch('TR');
    expect(entryPoint.querySelector('.size-td').textContent).toMatch('3');
    expect(entryPoint.querySelector('.date-td').textContent).toMatch('2019-08-02');
});