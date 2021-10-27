const mongoose = require ('mongoose');

const connectDatabase = () =>{
    mongoose.connect("mongodb://mongo:27017/payment-db",
        {
            useNewUrlParser: true,
            useUnifiedTopology:true,
        }).then(con =>{
            console.log(`MongoDB Database connected`)
        })
}


module.exports = connectDatabase;