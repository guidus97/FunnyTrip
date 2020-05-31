const randomWords = require('random-words')

module.exports = function generateString(){
    
    let generatedString = randomWords({exactly : 5, join : ' '})

    return generatedString.toString()
}