const express = require("express");
const router = express.Router();
const product = require('../models/product');
const session = require("express-session");

router.use(express.urlencoded({ extended: false }));
router.use(express.json());
router.use(session({ secret: "this is a scret key" }));

const products = [
      new product("panadol", 20,"Medicine", 1),
      new product("paracetamol", 20,"Medicine", 2),
      new product("advil", 30, "Medicine", 3),
      new product("cocacola", 30, "Medicine" ,4),
      new product("crack", 30, "Medicine", 5),
      new product("heroine", 30, "Medicine", 6),
      new product("tramadol", 30, "Medicine", 7)
];

router.get("/", (req, res) => {
  res.render("../views/product.ejs", {products: products});
});

router.get("/:id", (req, res) => {
  const id = parseInt(req.params.id);
  const productById = products.filter((x) => x.id === id);  
  res.render("../views/product.ejs", { products : productById });
});

router.post("/addtocart", (req, res) => {
  let name = req.body.name;
  let price = req.body.price;
  let product = products.filter((p) => p.name == name && p.price == price);
  if (product) {
    let cart = req.session.cart ? req.session.cart : [];
    let cartId = cart.length > 0 ? cart[cart.length - 1].cartId + 1 : 1;
    cart.push({ cartId, ...product[0] });
    req.session.cart = cart;
  }  
  res.redirect("/shoppingcart");
});

module.exports = router;