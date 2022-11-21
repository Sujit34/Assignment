const express = require("express");
const router = express.Router();
const product = require('../models/product');

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

module.exports = router;