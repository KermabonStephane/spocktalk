package org.demis27.simple

import org.demis27.Fibonacci
import spock.lang.Specification

class SimpleSpec extends Specification {

    def 'test fibonacci - then'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'I call the value for the index 6'
        def result = fibonacci.of(6)

        then: 'I expected the result is 8'
        result == 8
    }

    def 'test fibonacci - expect'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        expect: 'I expected the result is 8'
        fibonacci.of(6) == 8
    }
}
