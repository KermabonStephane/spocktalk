package org.demis27.exception

import org.demis27.Fibonacci
import org.demis27.FibonacciException
import org.demis27.FibonacciSequence
import org.demis27.FibonacciSequenceException
import spock.lang.Specification

class FibonacciExceptionSpec extends Specification{

    def 'test exception' () {
        given:
        Fibonacci fibonacci = new Fibonacci()

        when:
        fibonacci.getSequenceValue(-3)

        then:
        thrown FibonacciException
    }

    def 'test exception sequence' () {
        given:
        Fibonacci fibonacci = Mock()
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when:
        fibonacciSequence.getSequence(-1, 0)

        then:
        FibonacciSequenceException e = thrown()
        e.message == 'start and end must be positives'
    }
}
