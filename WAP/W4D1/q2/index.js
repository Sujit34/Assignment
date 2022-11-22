const express = require("express");
const path = require("path");
const app = express();
const bodyParser = require("body-parser");
const session = require('express-session');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(session({ secret: 'salt for cookie signing' })); 

app.post("/result", (request, response) => {
  request.session.name = request.body.username;
  request.session.age = request.body.age;
  
  if (!request.session.name) {
    request.session.name = "Default Name";
  }
  if (!request.session.age) {
    request.session.age = 0;
  }
  
 // response.send(`Welcome ${request.session.name}. You are ${request.session.age} years old.`);
 response.redirect('/output');
});

app.get("/", (request, response) => {
  response.render(path.join(__dirname, "view", "index.ejs"));
});

app.get(`/output`, (request, response, next) => {
  response.send(`Welcome ${request.session.name}, age ${request.session.age}`); 
})

app.listen(3000);