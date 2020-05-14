var mongo = require('../database/roomDb.js')
var kafka = require('kafka-node')
var conf = require('../config/kafka.js')

class RoomService {

    constructor() {
        this.repository = mongo
        this.client = new kafka.KafkaClient(conf.server)
        this.producer = new kafka.Producer(this.client)
    }

    async getRoomById(id) {

        try {

            let good = await this.repository.getById(parseInt(id))
            console.log('Good is: ' + good);
            
            if (good !== null && good instanceof Object) {

                return good
            }
            else {

                return null
            }

        } catch (ex) {
            console.error(ex);

        }
    }

    addRoomToDb(room) {

        /* let payload = [{
            topic : conf.topic,
            message : this.repository.addToDb(room)
        }] */

        let roomDb = this.repository.addToDb(room)
        console.log('RoomDb is: ' + roomDb)


        if (roomDb !== null && roomDb instanceof Object) {
            return roomDb
        }

        else {
            return null
        }
    }

    async getAll(){
        
        try {
            let listRooms = await this.repository.getAll()
    
            if (listRooms !== null && listRooms.length != 0){
                return listRooms
            } 
            else {
                return null
            }
        } catch (err) {
            throw err
        }

    }
}

module.exports = new RoomService()