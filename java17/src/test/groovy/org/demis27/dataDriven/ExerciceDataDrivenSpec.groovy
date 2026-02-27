package org.demis27.dataDriven

import org.demis27.Fibonacci
import spock.lang.Specification

class ExerciceDataDrivenSpec extends Specification {

    def 'test fibonacci - data table'() {
        given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci()

        expect: 'The result is as expected'
        fibonacci.of(input) == expected

        where: 'Inputs and expected results are'
        input || expected
        3     || 2
        // TODO: Add more rows to the data table
    }
}
