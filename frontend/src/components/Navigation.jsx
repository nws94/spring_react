import React from "react";
import { Link } from 'react-router-dom';

export default class Navigation extends React.Component {
  render() {
    return(
      <div>
        <Link to="/">
          Home
        </Link>
        <Link to="/sign-in">
          Sign In
        </Link>
        <Link to="/sign-up">
          Sign Up
        </Link>
      </div>
    )
  }
}