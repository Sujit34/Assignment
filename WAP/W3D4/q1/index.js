const express = require('express');
const index = express();

index.get('/', (req, res) => {
    let name = req.query.name;
    if (!name) {
    name = "person";
    }
    res.send(`Welcome ${name}`);
});


index.get('/:name/:age', (req, res) => {
    let name = req.params['name'];
    let age = parseInt(req.params['age']);
    res.send("Name: " + name + " Age: "+ age);
});

index.listen(3000);