package org.demis27.exception

import org.demis27.Fibonacci
import org.demis27.FibonacciException
import org.demis27.FibonacciSequence
import org.demis27.FibonacciSequenceException
import spock.lang.Specification

class ExerciceExceptionSpec extends Specification {

    def 'test exception' () {
        given: 'Create a fibonacci object'
        // TODO: Create a Fibonacci object

        when: 'Call with an invalid index (-3)'
        // TODO: Call the 'of' method with -3

        then: 'An exception is thrown'
        // TODO: Verify that FibonacciException is thrown
    }

    def 'test exception sequence' () {
        given: 'Create a fibonacci mock'
        // TODO: Create a Mock for Fibonacci
        and: 'Use it for a fibonacci sequence'
        // TODO: Initialize FibonacciSequence with the mock

        when: 'Call with an invalid parameter (-1, 0)'
        // TODO: Call getSequence(-1, 0)

        then: 'An exception is thrown and we have the right message'
        // TODO: Capture the exception variable and verify its message is 'start and end must be positives'
    }
}
