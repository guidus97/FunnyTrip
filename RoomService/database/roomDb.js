const Mongo = require('../factory/mongoFactory.js')
const url = 'mongodb://guidus97:mongoAdmin@192.168.1.69:27017'
const dbName = 'RoomService'
const Room = require('../model/room.js')


class RoomRepository {

    constructor() {
        this.mongo = Mongo;
        this.client = new Mongo(url)
    }

    async getById(id) {

        return new Promise(async (resolve, reject) => {

            try {

                this.client.connect(async (err, database) => {

                    if (err) {
                        reject(err)
                    }

                    try {
                        const db = this.client.db(dbName)
                        let data = await db.collection('rooms').findOne({ id: parseInt(id) })
                        let instance

                        console.log('Data is: ' + JSON.stringify(data))


                        if (data !== undefined && data !== null && JSON.stringify(data) !== JSON.stringify({})) {
                            instance = new Room(data.id, data.name, data.location, data.city, data.price)
                            console.log('Instance of room is: ' + JSON.stringify(instance))
                            resolve(instance)
                        } else {
                            resolve(null)
                        }

                    } catch (err) {
                        console.error(err);
                        reject(err)
                    }

                })

            } catch (err) {
                throw err
            }
        })
    }

    async getAll() {

        return new Promise((resolve, reject) => {

            try {
                this.client.connect(async (err, database) => {

                    if (err) {
                        console.log('Error connection: ' + err)

                        reject(err)
                    }

                    try {
                        const db = this.client.db(dbName)
                        let listOfRoom = await db.collection('rooms').find({}).toArray()

                        if (listOfRoom.length > 0) {
                            resolve(listOfRoom)
                        }

                    } catch (err) {
                        reject(err)
                    }
                })

            } catch (err) {
                reject(err)
            }
        })
    }

    addToDb(room) {

        let instance = {}

        this.client.connect((err, database) => {

            if (err) {
                console.log('Error connection: ' + err)

                throw err
            }

            const db = this.client.db(dbName)

            db.collection('rooms').insertOne(room, (err, res) => {

                if (err) {
                    throw err
                }

                console.log('Returning a room');

                instance = new Room(res.id, res.name, res.location, res.city, res.price)
                console.log('Instance is: ' + instance)
            })
        })

        return instance
    }

    updateById() {

    }

    deleteById() {

    }
}

module.exports = new RoomRepository()