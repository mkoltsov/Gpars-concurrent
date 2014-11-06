@Grab(group = 'org.codehaus.gpars', module = 'gpars', version = '1.2.1')
import groovyx.gpars.GParsPool

GParsPool.withPool {
    def animals = ['dog', 'ant', 'cat', 'whale']
    def numbers = [1324314134L, 54354354353L, 434324324324L, 434343434L, 4342342342L, 342342342L, 3432423424L, 42342342342342L, 432423423432L, 434234234L, 32423423423424242L]
    println animals.anyParallel { it ==~ /ant/ } ? 'Found an ant' : 'No ants found'
    println animals.everyParallel { it.contains('a') } ? 'All animals contain a' : 'Some animals can live without an a'
    println "max = " + numbers.maxParallel()
    println "sum = " + numbers.sumParallel()
    println animals.collectParallel { _ -> _.startsWith('a') ? "an $_" : "a $_" }
}