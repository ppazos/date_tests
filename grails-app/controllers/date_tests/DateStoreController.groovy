package date_tests

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import util.DateParser
import java.text.SimpleDateFormat

@Transactional(readOnly = true)
class DateStoreController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    
    // TODO: otro controller que ande con UTC
    // TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DateStore.list(params), model:[dateStoreInstanceCount: DateStore.count()]
    }

    def show(DateStore dateStoreInstance) {
        respond dateStoreInstance
    }

    def create() {
        respond new DateStore(params)
    }

    @Transactional
    def save(String fromClient, String fromClientUTC)
    {
    /*
        params.each{ k, v ->
        
           println k +": +"+ v
        }
        println "."
    */
        // date with local tz from client
        def fromClientDate = DateParser.tryParse(fromClient)
        def fromClientUTCDate = DateParser.tryParse(fromClientUTC)
        
        println "fromClientDate $fromClientDate"
        println "fromClientUTCDate $fromClientUTCDate"
        println "."
        
        // to UTC date
        SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"))
        def dateUTCString = dateFormatUTC.format(fromClientDate)
        def toUTC = DateParser.tryParse(dateUTCString)
        
        println "toUTC $toUTC"
        println "."
        
        def dateStoreInstance = new DateStore(
           fromClient: fromClientDate,
           fromClientUTC: fromClientUTCDate,
           toUTC: toUTC
        )
    
        if (dateStoreInstance == null) {
            notFound()
            return
        }

        if (dateStoreInstance.hasErrors()) {
            respond dateStoreInstance.errors, view:'create'
            return
        }

        dateStoreInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dateStore.label', default: 'DateStore'), dateStoreInstance.id])
                redirect dateStoreInstance
            }
            '*' { respond dateStoreInstance, [status: CREATED] }
        }
    }

    def edit(DateStore dateStoreInstance) {
        respond dateStoreInstance
    }

    @Transactional
    def update(DateStore dateStoreInstance) {
        if (dateStoreInstance == null) {
            notFound()
            return
        }

        if (dateStoreInstance.hasErrors()) {
            respond dateStoreInstance.errors, view:'edit'
            return
        }

        dateStoreInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DateStore.label', default: 'DateStore'), dateStoreInstance.id])
                redirect dateStoreInstance
            }
            '*'{ respond dateStoreInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DateStore dateStoreInstance) {

        if (dateStoreInstance == null) {
            notFound()
            return
        }

        dateStoreInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DateStore.label', default: 'DateStore'), dateStoreInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dateStore.label', default: 'DateStore'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
