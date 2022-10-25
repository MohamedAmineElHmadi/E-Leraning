const express = require("express");
const router = express.Router();
const Quote = require("../Models/quoteModel");
const validator = require("validator");
const Customer = require("../Models/customerModel");
const Reseller = require('../Models/resellerModel')
const ID = require("nodejs-unique-numeric-id-generator")

//find all
router.get("/", function (req, res) {
  Quote.find({})
    .then((data) => {
      return res.status(201).json(data);
    })
    .catch((error) => {
      return res.status(401).json(error);
    });
});

//find one
router.get("/:id", function (req, res) {
  Quote.findById(req.params.id, function (err, Quote) {
    if (err) return res.status(500).send({ err });
    if (!Quote) return res.status(404).send("No Quote found.");
    res.status(200).send(Quote);
  });
});

router.post("/", (req, res) => {
  distributor = req.body.distributor;
  reseller = req.body.reseller;
  customer = req.body.customer;
  quoteLine =  req.body.quoteLine;

  if (distributor == undefined)
    return res.status(401).json({ Error: "distributor is a required field!" });
      const quote = new Quote({
        distributor: distributor,
        reseller: reseller,
        customer: customer,
        quoteLine : quoteLine,
        number : "Q-" + ID.generate(new Date().toJSON()),
      });
      quote
        .save()
        .then((data) => {
          return res.status(201).json(data);
        })
        .catch((error) => {
          return res.status(401).json(error);
        });
    });





//delete
router.delete("/:id", function (req, res) {
  Quote.findByIdAndDelete(req.params.id, function (err, Quote) {
    if (err)
      return res.status(500).send("There was a problem deleting the Quote.");
    res.status(200).send(Quote);
  });
});



router.get("/getBycustomer/:customer", function (req, res) {
  
  Quote.find({ "customer._id": req.params.customer })
    .then((data) => {
      if (data) {
        console.log(data)
        return res.status(201).json(data);
      } else {
        return res
          .status(201)
          .json({ Result: "Couldn't find a quote with this customer!" });
      }
    })
    .catch((error) => {
      return res.status(401).json(error);
    });
});
router.get("/getByreseller/:reseller", function (req, res) {
  Quote.find({ "reseller._id": req.params.reseller })
    .then((data) => {
      if (data) {
        return res.status(201).json(data);}
      else {
        return res
          .status(201)
          .json({ Result: "Couldn't find a quote with this reseller!" });
      }
    })
    .catch((error) => {
      return res.status(401).json(error);
    });
});

router.get("/getByStatus/:status", function (req, res) {
  Quote.find({ "status": req.params.status })
    .then((data) => {
      if (data) {
        return res.status(201).json(data);
      } else {
        return res
          .status(201)
          .json({ Result: "Couldn't find a quote with this Status!" });
      }
    })
    .catch((error) => {
      return res.status(401).json(error);
    });
});

router.get("/getByStatus/:status/:reseller", function (req, res) {
  Quote.find({ "status": req.params.status , "reseller._id": req.params.reseller})
    .then((data) => {
      if (data) {
        return res.status(201).json(data);
      } else {
        return res
          .status(201)
          .json({ Result: "Couldn't find a quote with this Status!" });
      }
    })
    .catch((error) => {
      return res.status(401).json(error);
    });
});
module.exports = router;
