package org.demis27.stubMockAndSpy


import spock.lang.Specification

class ExerciseStubSequenceSpec extends Specification {

    def 'test fibonacci sequence stub'() {
        given: 'Stub the fibonacci '
        // TODO: Create a Stub for Fibonacci

        and: 'Create the sequence with this stub'
        // TODO: Initialize FibonacciSequence with the stub

        and: 'Declare what the fibonacci stub returns'
        // TODO: Use the '>>>' operator to return [0, 1, 1] for any call

        when: 'Call the fibonacci sequence'
        // TODO: call getSequence(0, 2)

        then: 'We have the right list'
        // TODO: verify the sequence is [0, 1, 1]
    }

    def 'test fibonacci sequence mock'() {
        given: 'Mock the fibonacci'
        // TODO: Create a Mock for Fibonacci

        and: 'Create the sequence with this mock'
        // TODO: Initialize FibonacciSequence with the mock

        when: 'Call the fibonacci sequence'
        // TODO: call getSequence(0, 2)

        then: 'We call three time the fibonacci object'
        // TODO: verify 3 * fibonacci.of(_)
    }

    def 'test fibonacci sequence mock and stub'() {
        given: 'Mock the fibonacci'
        // TODO: Create a Mock for Fibonacci

        and: 'Create the sequence with this mock'
        // TODO: Initialize FibonacciSequence with the mock

        when: 'Call the fibonacci sequence'
        // TODO: call getSequence(0, 2)

        then: 'Declare what the fibonacci stub returns and check how many time it call'
        // TODO: combine interaction and stubbing: 3 * fibonacci.of(_) >>> [0, 1, 1]

        and: 'We have the right list'
        // TODO: verify result
    }
}
