//imports
const express = require('express')
const app =express()
const mongoose = require('mongoose')
const dotenv = require("dotenv")
var bodyParser = require('body-parser')
const authRoutes = require("./Controllers/authController")
//const resellerRoutes = require("./Controllers/resellerController")
const customerController =  require("./Controllers/customerController")
const quoteController =  require("./Controllers/quoteController")
//const subscriptionRoutes = require("./Controllers/subscriptionRoutes.js")
//const distrubutorRoutes = require("./Controllers/distributorRoute.js")
//const sendEmailRoute = require("./Controllers/sendEmail.js")
//const productController =  require("./Controllers/productController")
//const invoiceController =  require("./Controllers/invoiceController")
const checkoutController =  require("./Controllers/checkoutController")
//const billController =  require("./Controllers/billController")
const path = require('path');
const cors = require("cors")



//configuration of .env
dotenv.config();

//connection to database
mongoose.connect(process.env.DATABASE_URL,()=> console.log("Database Connected!"))

//routing
app.use(bodyParser.json())
app.use(
    bodyParser.urlencoded({
      extended: false,
    }),
  )
app.use('/public', express.static('public'))
app.use(cors())
app.use("/auth",authRoutes)
//app.use("/reseller",resellerRoutes)
app.use("/customer",customerController)
//app.use("/subscription",subscriptionRoutes)
//app.use("/distrubutor",distrubutorRoutes)
app.use("/quote",quoteController)
//app.use("/sendMail",sendEmailRoute)
//app.use("/product",productController)
//app.use("/invoice",invoiceController)
app.use("/checkout",checkoutController)
//app.use("/bill",billController)
//app.use('/api/uploads', express.static(path.join(__dirname, 'images')));

//const Quote = require("./Models/quoteModel");

//launching the server
app.listen(3000,()=> console.log("server up and running on port 3000!"))
