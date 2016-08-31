import java.util.TimeZone

class BootStrap {

    def init = { servletContext ->
    
       TimeZone.setDefault(TimeZone.getTimeZone('UTC'))
       println "default TZ: " + (TimeZone.getDefault().getRawOffset() / 1000 / 60 / 60) // milisegundos a horas
    }
    def destroy = {
    }
}
