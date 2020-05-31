var router = require('../factory/routerFactory.js')
var api = require('../factory/routerFactory.js')
var express = require('express')
var app = express()
var body_parser = require('body-parser')
var port = Number.parseInt(process.argv[2]) || 3000
var RoomController = require('../router/controller.js')
var eureka = require('../config/eureka.js')

app.use(body_parser.json())
app.use('/roomService', router)
router.use('/methods', api)

eureka(port)

var room = new RoomController(api)

app.listen(port , () => {
    console.log('Listening on port: ' + port);
    
})

module.exports = app
