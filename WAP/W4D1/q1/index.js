const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(3000, () => {
    console.log('apps run on 3000 port.');
});

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'view'));

let cookie = {};

app.get('/', (req, res) => {
    res.render('add-cookie', { cookie });
});

let cookieData = {
    arrayKey: [],
    arrayValue: []
};

app.post('/add', (req, res) => {
    let key = req.body.key;
    let value = req.body.value;
    if (key && value) {
        res.cookie(key, value);        
      }
    res.redirect("back");
});

