const express = require('express')
const app = express()
const connectDatabase = require('./config/database')
const dotenv = require('dotenv')
const paymentController = require('./controllers/payment');
const Eureka = require('eureka-js-client').Eureka;



dotenv.config()
connectDatabase()

app.listen(3005, () =>
  console.log('Application Started Working' )
)
app.use(express.json())
app.use("/api",paymentController);

const client = new Eureka({
    instance: {
      instanceId:'payment',

      app: 'payment',
      hostName: 'payment',
      statusPageUrl:'http://localhost:3005',
      ipAddr: '0.0.0.0 ',
      port: {
        '$': 3005,
        '@enabled': 'true',
      },
      vipAddress: 'payment',
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },
      registerWithEureka:true,
      fetchRegistry:true,
    },
    eureka: {
        
        
        // eureka server host / port
        /*serviceUrls: {
          default: [
            'http://discovery:8761/eureka/apps',
            
          ]
        },*/
        host:'discovery',
        port:8761,
        servicePath: '/eureka/apps/'
      },
  });

  client.start()
