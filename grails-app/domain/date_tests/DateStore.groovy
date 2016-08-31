package date_tests

class DateStore {

    Date fromClient // local tz
    Date toUTC      // local tz to UTC in the server
    Date fromClientUTC // transformed to UTC in the client

    def beforeInsert() {
    
    }
    
    static constraints = {
    
    }
}
