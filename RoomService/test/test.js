'use strict'

let mocha = require('mocha')
let chai = require('chai')
let chai_http = require('chai-http')
let server = require('../main/index.js')
let generatedString = require('../utils/stringGenerator.js')

chai.should()
chai.use(chai_http)

describe('RoomService REST Api', () => {

    describe('GET requests', () => {

        it('GET room by id', (done) => {

            chai.request(server)
                .get('/roomService/methods/getRoom/' + Number.parseInt(1))
                .end((err, res) => {

                    res.should.have.status(200)
                    chai.expect(res.body).to.contain.property('id')
                    chai.expect(res.body).to.contain.property('name')
                    chai.expect(res.body).to.contain.property('location')
                    chai.expect(res.body).to.contain.property('city')
                    chai.expect(res.body).to.contain.property('price')
                    done()
                })
        })

        it('GET all rooms',(done) => {
            chai.request(server)
                .get('/roomService/methods/getAllRooms')
                .end((err,res) => {
                    res.should.have.status(200)
                    chai.expect(res.body).to.be.an('array').that.have.length.above(0)
                    done()
                })

        })
    })

    describe('POST request',() => {
        
        it('POST room', (done) => {
            
            chai.request(server)
                .post('/roomService/methods/addRoom')
                .send({'id': 5, 'name': generatedString() , 'location': generatedString(), 'city': generatedString(), 'price': 1000})
                .end((err,res) => {
                    res.should.have.status(200)
                    chai.expect(res.body).is.a('object')
                    chai.expect(res.body).that.has.property('id')
                    chai.expect(res.body).that.has.property('name')
                    chai.expect(res.body).that.has.property('location')
                    chai.expect(res.body).that.has.property('city')
                    chai.expect(res.body).that.has.property('price')
                    done()
                })                
        })
    })
})