const express = require('express');
const index = express();
var bodyParser = require('body-parser'); 
var urlencodedParser = bodyParser.urlencoded({ extended: false })

index.use(express.static('public'));
index.get('/index.html', function (req, res) {
    res.sendFile(__dirname + "/" + "index.html");
})

index.post('/result', urlencodedParser, function (req, res) {
    response = {
        name: req.body.name,
        age: req.body.age
    };
    console.log(response);
    res.end(JSON.stringify(response));
})



index.listen(4000);