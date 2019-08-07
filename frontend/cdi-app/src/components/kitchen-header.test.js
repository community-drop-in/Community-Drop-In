import React from 'react';
import ReactDOM from 'react-dom';
import KitchenHeader from './kitchen-header';


describe('Kitchen Header Component', () => {
    test('renders', () => {
        const entryPoint = document.createElement('div');
        ReactDOM.render(<KitchenHeader />, entryPoint);
        expect(entryPoint.querySelector('.kitchen-main-header') instanceof HTMLElement).toBeTruthy();
    })

});