@Grab(group='org.codehaus.gpars', module='gpars', version='1.2.1')
import groovyx.gpars.actor.DynamicDispatchActor
import org.codehaus.groovy.runtime.NullObject

final class MyActor extends DynamicDispatchActor {
    private int counter = 0

    void onMessage(String message) {
        counter += message.size()
        println 'Received string'
    }

    void onMessage(Integer message) {
        counter += message
        println 'Received integer'
    }

    void onMessage(Object message) {
        counter += 1
        println 'Received object'
    }

    void onMessage(NullObject message) {
        println 'Received a null object. Sending back the current counter value.'
        reply counter
    }
}

final def actor = new MyActor()
actor.start()
actor.send 1
actor << 2
actor 20
actor 'Hello'
println actor.sendAndWait(null)