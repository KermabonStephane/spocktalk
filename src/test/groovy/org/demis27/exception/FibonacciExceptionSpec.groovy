package org.demis27.exception

import org.demis27.Fibonacci
import org.demis27.FibonacciException
import org.demis27.FibonacciSequence
import org.demis27.FibonacciSequenceException
import spock.lang.Specification

class FibonacciExceptionSpec extends Specification{

    def 'test exception' () {
        given: 'Create a fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'Call with an invalid index'
        fibonacci.getSequenceValue(-3)

        then: 'An exception is thrown'
        thrown FibonacciException
    }

    def 'test exception sequence' () {
        given: 'Create a fibonacci mock'
        Fibonacci fibonacci = Mock()
        and: 'Use it for a fibonacci sequence'
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when: 'Call with an invalid parameter'
        fibonacciSequence.getSequence(-1, 0)

        then: 'An exception is throws and we have the right message'
        FibonacciSequenceException e = thrown()
        e.message == 'start and end must be positives'
    }
}
