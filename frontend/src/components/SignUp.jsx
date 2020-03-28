import React from "react";
import axios from 'axios';
import TextField from "@material-ui/core/TextField"
import Button from "@material-ui/core/Button"

export default class SignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      email : '',
      password: '',
      name: ''
    }
  }
  handleValueChange = (e) => {
    let nextState = {};
    nextState[e.target.name] = e.target.value;
    this.setState(nextState);
  }
  handleSubmit = (e) => {
    e.preventDefault();
    this.handleSignUp().then((res) => {
      if(res.data.success) {
        this.props.history.push("/signin");
      }
    }).catch((err) => {
      console.log(err.response.data);
    })
  }
  handleSignUp = () => {
    const formData = new FormData();
    formData.append("id", this.state.email);
    formData.append("password",this.state.password);
    formData.append("name",this.state.name);
    
    return  axios.post("/signup",formData);
  }
  render() {
    return(
      <div>
        <TextField label="email" type="email" name="email" value={this.state.email} onChange={this.handleValueChange}/><br></br>
        <TextField label="name" type="text" name="name" value={this.state.name} onChange={this.handleValueChange}/><br></br>
        <TextField label="password" type="password" name="password" value={this.state.password} onChange={this.handleValueChange}/><br></br>
        <Button variant="contained" color="primary" onClick={this.handleSubmit}>회원가입</Button>
      </div>
    )
  }
}