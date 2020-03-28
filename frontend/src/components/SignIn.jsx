import React from "react";
import axios from 'axios';
import TextField from "@material-ui/core/TextField"
import Button from "@material-ui/core/Button"

export default class SignIn extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      email:'',
      password: ''
    }
  }
  handleValueChange = (e) => {
    let nextState = {};
    nextState[e.target.name] = e.target.value;
    this.setState(nextState);
  }
  handleSubmit = (e) => {
    e.preventDefault();
    this.handleSignIn().then((res) => {
      if(res.data.success) {
        this.props.history.push("/");
      }
    }).catch((err) => {
      console.log(err.response.data);
    })
  }
  handleSignIn = () => {
    const formData = new FormData();
    formData.append("id", this.state.email);
    formData.append("password",this.state.password);

    return  axios.post("/signin",formData);
  }
 
  render() {
    return (
      <div>
        <TextField label="email" type="email" name="email" value={this.state.email} onChange={this.handleValueChange}/><br></br>
        <TextField label="password" type="password" name="password" value={this.state.password} onChange={this.handleValueChange}/><br></br>
        <Button variant="contained" color="primary" onClick={this.handleSubmit}>로그인</Button>
      </div>
    )
  }
}

