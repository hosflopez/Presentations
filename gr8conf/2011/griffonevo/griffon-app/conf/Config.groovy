log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error  'org.codehaus.griffon'
    error  'org.springframework'

    info   'griffon.util',
           'griffon.core',
           'griffon.swing',
           'griffon.app'
}

presentation.screenWidth = 1024
presentation.screenHeight = 768

lookandfeel.lookAndFeel = 'System'
lookandfeel.theme = 'Nimbus'

griffon.rest.injectInto = ['controller', 'service']
