import React from "react";

export default class SignIn extends React.Component {
  render() {
    return (
      <div>
        <form>
        <input type="email" placeholder="Your Email"/><br/>
          <input type="password" placeholder="Your Password"/><br/>
          <input type="submit" value="Sign In"/> 
        </form>
      </div>
    )
  }
}

