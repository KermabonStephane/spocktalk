package org.demis27.stubAndMock

import org.demis27.Fibonacci
import org.demis27.FibonacciSequence
import spock.lang.Specification

class FibonacciSequenceSpec extends Specification {

    def 'test fibonacci sequence stub' () {
        given:
        Fibonacci fibonacci = Stub()
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        and: 'stub fibonacci'
        fibonacci.getSequenceValue(_) >>> [0,1,1]

        when:
        def sequence = fibonacciSequence.getSequence(0, 2)

        then:
        sequence ==  [0, 1, 1]
    }

    def 'test fibonacci sequence mock' () {
        given:
        Fibonacci fibonacci = Mock()
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when:
        fibonacciSequence.getSequence(0, 2)

        then:
        3 * fibonacci.getSequenceValue(_)
    }

    def 'test fibonacci sequence mock and stub' () {
        given:
        Fibonacci fibonacci = Mock()
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when:
        def sequence = fibonacciSequence.getSequence(0, 2)

        then:
        3 * fibonacci.getSequenceValue(_) >>> [0,1,1]
        sequence ==  [0, 1, 1]
    }

    def 'spy the fibonacci on sequence' (){
        given:
        Fibonacci fibonacci = Spy()
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when:
        fibonacciSequence.getSequence(0, 2)

        then:
        2 * fibonacci.getSequenceValue(0)
        2 * fibonacci.getSequenceValue(1)
        1 * fibonacci.getSequenceValue(2)
    }
}
