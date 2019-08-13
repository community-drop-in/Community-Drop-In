import React from 'react';
import Api from './Api/Api';
import './App.css';
import MainHeader from './components/main-header';

function App() {
  return (
    <>
    <MainHeader/>
    <Api />
    </>
  );
}

export default App;
