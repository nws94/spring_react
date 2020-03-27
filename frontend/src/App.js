import React from 'react';
import { Route } from 'react-router-dom';
import Navigation from './components/Navigation';
import SignIn from "./components/SignIn";
import SignUp from "./components/SignUp";
import Home from "./components/Home"
import './App.css';

function App() {
  return (
    <div className="App">
      <Navigation/>
      <Route exact path="/" component={Home} />
      <Route exact path="/signin" component={SignIn} />
      <Route exact path="/signup" component={SignUp} />
    </div>
  );
}

export default App;
