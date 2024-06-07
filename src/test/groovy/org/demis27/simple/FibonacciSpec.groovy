package org.demis27.simple

import org.demis27.Fibonacci
import spock.lang.Specification

class FibonacciSpec extends Specification {

    def 'test fibonacci - then'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'I call the value for the index 6'
        def result = fibonacci.getSequenceValue(6)

        then: 'I expected the result is 8'
        result == 8
    }

    def 'test fibonacci - expect'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        expect: 'I expected the result is 8'
        fibonacci.getSequenceValue(6) == 8
    }
}
