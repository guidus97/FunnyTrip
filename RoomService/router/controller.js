var RoomService = require('../service/roomService.js')

class RoomController {

    constructor(router) {
        this.router = router
        this.registerRoutes()
    }

    registerRoutes() {
        this.router.get('/getRoom/:id', this.getRoom.bind(this))
        this.router.post('/addRoom', this.postRoom.bind(this))
        this.router.get('/getAllRooms', this.getAllRooms.bind(this))
    }

    async getRoom(req, res) {

        const id = req.params.id

        console.log(id);

        try {

            let room = await RoomService.getRoomById(parseInt(id))
            console.log('Room is: ' + JSON.stringify(room));

            if (room !== null && JSON.stringify(room) !== JSON.stringify({})) {
                await res.send(room)
            }
            else {
                await res.status(404).json({ error: 'The room is not found in database' })
            }

        } catch (ex) {
            console.error(ex);

        }

    }

    postRoom(req, res) {

        let room = req.body

        console.log('Room is: ' + room);

        let good = RoomService.addRoomToDb(room)

        console.log('Good is: ' + good);

        if (good === null) {
            res.status(500).json({ error: 'Room not added' })
        }

        else {
            res.json(room)
        }
    }

    async getAllRooms(req, res) {

        try {
            let list = await RoomService.getAll()
    
            if (list !== null) {
                res.json(list)
            }
    
            else {
                res.status(500).json({ error: 'List of rooms not retrieved' })
            }
        } catch (err) {
            throw err
        }
    }

}

module.exports = RoomController