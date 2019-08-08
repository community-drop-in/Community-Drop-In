import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Api from './Api/Api'
import * as serviceWorker from './serviceWorker';
// import Counter from './components/counter.jsx'
import Finder from './components/Finder.js'

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
