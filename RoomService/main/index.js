var router = require('../factory/routerFactory.js')
var api = require('../factory/routerFactory.js')
var express = require('express')
var app = express()
var body_parser = require('body-parser')
var port = process.argv[2]
var RoomController = require('../router/controller.js')

app.use(body_parser.json())
app.use('/roomService', router)
router.use('/methods', api)

var room = new RoomController(api)

app.listen(port , () => {
    console.log('Listening on port: ' + port);
    
})
