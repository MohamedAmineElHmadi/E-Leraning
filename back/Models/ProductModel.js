const mongoose = require('mongoose');


const ProductModelSchema = new mongoose.Schema({

    category : {
        type : String,
        required : true
    },

    product_name : {
        type : String,
        required : true
    },
    package : {
        type : String,
        required : true
    },
    type : {
        type : String,
        required : true
    },
    term : {
        type : String,
        required : true
    },
    SKU : {
        type : String,
        required : true
    },

    band_A : {
        type : Number,
        
    },
    band_B : {
        type : Number,
        
    },
    band_C : {
        type : Number,
        
    },
    band_D : {
        type : Number,
        
    },
    band_E : {
        type : Number,
        
    },
    band_K : {
        type : Number,
        
    },
    band_M : {
        type : Number,
        
    },
    band_N : {
        type : Number,
        
    },
    band_P : {
        type : Number,
        
    },
    band_Q : {
        type : Number,
        
    },
    band_R : {
        type : Number,
        
    },
    band_S : {
        type : Number,
        
    },
    band_T : {
        type : Number,
        
    }
})

module.exports = mongoose.model('product' , ProductModelSchema )