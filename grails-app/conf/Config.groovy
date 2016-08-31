// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

app {
   l10n { // localization

      // formatos de fechas
      // ==================
      //  - ref: http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
      //
      // h hora 1-12
      // H hora 0-23
      // a marcador AM/PM
      // m minutis
      // S milisegundos
      // Z zona horaria (RFC 822)
      
      // formatos para procesamiento de fechas
      // incluye fraccion (debe estar separado con el decimal_symbol) y zona horaria
      datetime_format = "yyyyMMdd'T'HHmmss,SSSZ" 
      date_format = "yyyyMMdd"
      time_format = "HHmmss"
      
      
      // Extended formats supported by openEHR --------------------------------------------------------------
      //2015-12-02T17:41:56.809Z
      ext_datetime_format = "yyyy-MM-dd'T'HH:mm:ss,SSSZ" // contains timezone e.g. -0300
      ext_datetime_format_point = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
      // If the time is in UTC, add a Z directly after the time without a space. Z is the zone
      // designator for the zero UTC offset. "09:30 UTC" is therefore represented as "09:30Z" or "0930Z".
      ext_datetime_utcformat = "yyyy-MM-dd'T'HH:mm:ss,SSS'Z'"
      ext_datetime_utcformat_point = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
      // ----------------------------------------------------------------------------------------------------
      
      
      // Dates without seconds fraction
      datetime_format_nof = "yyyyMMdd'T'HHmmssZ"
      ext_datetime_format_nof = "yyyy-MM-dd'T'HH:mm:ssZ"
      ext_datetime_utcformat_nof = "yyyy-MM-dd'T'HH:mm:ss'Z'"
      
      
      // formatos para mostrar las fechas al usuario
      display_datetime_format = "yyyy/MM/dd HH:mm:ss (Z)" 
      display_date_format = "yyyy/MM/dd"
      display_time_format = "HH:mm:ss"
      
      db_datetime_format = "yyyy-MM-dd HH:mm:ss" // mysql no soporta fragment o timezone, otros dbms si
      db_date_format = "yyyy-MM-dd"
      db_time_format = "HH:mm:ss"
   }
}