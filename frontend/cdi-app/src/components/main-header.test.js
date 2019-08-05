import React from 'react';
import ReactDOM from 'react-dom';
import MainHeader from './main-header';

describe('Main Header Component', () => {
    test('renders', () => {
        const entryPoint = document.createElement('div');
        entryPoint.classList.add('container');
        ReactDOM.render(<MainHeader />, entryPoint);
        expect(entryPoint.querySelector('.main-header') instanceof HTMLElement).toBeTruthy();
    });

    test('render h1 with class name main-header__title', () => {
        const entryPoint = document.createElement('div');
        ReactDOM.render(<MainHeader />, entryPoint);
        expect(entryPoint.querySelector('.main-header__title').tagName).toMatch('H1');
        expect(entryPoint.querySelector('.main-header__title').textContent).toMatch('Community Drop In Center');
    });

});