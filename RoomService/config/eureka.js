var Eureka = require('eureka-js-client').Eureka

function registerEureka(port) {

    const client = new Eureka({

        instance: {
            app: 'room_service',
            hostName: 'localhost',
            ipAddr: '192.168.1.69',
            statusPageUrl: 'http://192.168.1.69:' + port + '/info',
            port: {
                '$' : port,
                '@enabled': true
            },
            vipAddress: 'org.onlineSolutions.FunnyTrip.RoomService',
            dataCenterInfo : {
                name : 'MyOwn',
                '@class' : 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo'
            }
        },

        eureka: {
            host: '192.168.1.69',
            port: '9900',
            servicePath : '/eureka/apps/'
        }
    })

    client.start()
}

module.exports = registerEureka


