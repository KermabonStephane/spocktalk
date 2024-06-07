package org.demis27.stubMockAndSpy

import org.demis27.Fibonacci
import org.demis27.FibonacciSequence
import spock.lang.Specification

class FibonacciSequenceSpec extends Specification {

    def 'test fibonacci sequence stub'() {
        given: 'Stub the fibonacci '
        Fibonacci fibonacci = Stub()
        and: 'Create the sequence with this stub'
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        and: 'Declare what the fibonacci stub returns'
        fibonacci.getSequenceValue(_) >>> [0, 1, 1]

        when: 'Call the fibonacci sequence'
        def sequence = fibonacciSequence.getSequence(0, 2)

        then: 'We have the right list of third fibonacci elements'
        sequence == [0, 1, 1]
    }

    def 'test fibonacci sequence mock'() {
        given: 'Mock the fibonacci'
        Fibonacci fibonacci = Mock()
        and: 'Create the sequence with this mock'
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when: 'Call the fibonacci sequence'
        fibonacciSequence.getSequence(0, 2)

        then: 'We call three time the fibonacci object'
        3 * fibonacci.getSequenceValue(_)
    }

    def 'test fibonacci sequence mock and stub'() {
        given: 'Mock the fibonacci'
        Fibonacci fibonacci = Mock()
        and: 'Create the sequence with this mock'
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when: 'Call the fibonacci sequence'
        def sequence = fibonacciSequence.getSequence(0, 2)

        then: 'Declare what the fibonacci stub returns and check how many time it call'
        3 * fibonacci.getSequenceValue(_) >>> [0, 1, 1]

        and: 'We have the right list of third fibonacci elements'
        sequence == [0, 1, 1]
    }

    def 'spy the fibonacci on sequence'() {
        given: 'Add a spy on the fibonacci object'
        Fibonacci fibonacci = Spy()
        and: 'Create the sequence with this spy'
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci)

        when: 'Call the fibonacci sequence'
        fibonacciSequence.getSequence(0, 2)

        then: 'We call two times the sequence value for position 0'
        2 * fibonacci.getSequenceValue(0)
        and: 'We call two times the sequence value for position 1'
        2 * fibonacci.getSequenceValue(1)
        and: 'We call one time the sequence value for position 2'
        1 * fibonacci.getSequenceValue(2)
    }
}
