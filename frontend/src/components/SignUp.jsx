import React from "react";

export default class SignUp extends React.Component {
  render() {
    return(
      <div>
        <form >
          <input type="text" placeholder="Your Name"/><br/>
          <input type="email" placeholder="Your Email"/><br/>
          <input type="password" placeholder="Your Password"/><br/>
          <input type="submit" value="Sign Up"/> 
        </form>
      </div>
    )
  }
}