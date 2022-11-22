const express = require("express");
const router = express.Router();
const shoppingcart = require('../models/shoppingcart');
const session = require("express-session");

/*
const cart = [
    new shoppingcart("panadol", 20,"Medicine", 1,3),
    new shoppingcart("paracetamol", 20,"Medicine", 2,3),
    new shoppingcart("advil", 30, "Medicine", 3,3),
    new shoppingcart("cocacola", 30, "Medicine" ,4,3)
];
*/
router.get("/", (req, res) => {
  console.log(req);
  let cart = req.session.cart ? req.session.cart : [];
  console.log(cart);
  res.render("../views/shoppingcart.ejs", { cart: cart });
});

module.exports = router;