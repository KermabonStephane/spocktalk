package org.demis27.dataDriven

import org.demis27.Fibonacci
import spock.lang.Specification

class FibonacciDataDrivenSpec extends Specification {

    def 'test fibonacci - data table'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'I call the value for the input index'
        def result = fibonacci.getSequenceValue(input)

        then: 'The result is as expected'
        result == expected

        where: 'Inputs and expected results are'
        input || expected
        3     || 2
        4     || 3
        5     || 5
        6     || 8
    }

    def 'test fibonacci - data pipe'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'I call the value for the input index'
        def result = fibonacci.getSequenceValue(input)

        then: 'The result is as expected'
        result == expected

        where: 'Inputs and expected result are'
        input << [3, 4, 5, 6]
        expected << [2, 3, 5, 8]
    }

    def 'test fibonacci - multi variable data pipe' () {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        when: 'I call the value for the input index'
        def result = fibonacci.getSequenceValue(input)

        then: 'The result is as expected'
        result == expected

        where:  'Inputs and expected result are'
        [input, expected] << [[3, 2], [4, 3], [5, 5], [6, 8]]
    }
}
