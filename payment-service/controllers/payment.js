const express = require('express')
const router = express.Router();
const Payment = require('../models/payment');

router.get('/', (req, res) => {
    res.json('Hi');
})


router.post('/payment', async (req, res) => {
    const { userId, reservationID } = req.body;

    try {
        // payment gateway logic ( example stripe )
    } catch (error) {
        console.log(error)
        res.status(500).json(error)
    }
    res.json(userId, reservationID);
})




module.exports = router;
