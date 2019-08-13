import React from 'react';
import AppRouter from './Api/AppRouter';
import './App.css';
import MainHeader from './components/main-header';

function App() {
  return (
    <>
    <MainHeader/>
    <AppRouter />
    </>
  );
}

export default App;
