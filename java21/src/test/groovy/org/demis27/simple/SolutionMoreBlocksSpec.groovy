package org.demis27.simple

import spock.lang.Specification

class SolutionMoreBlocksSpec extends Specification {

    def "use and: block for readability"() {
        given: "a message"
        def msg = "Hello"

        and: "a name"
        def name = "Spock"
        
        when: "we combine them"
        def result = "$msg $name"

        then: "the result is correct"
        result == "Hello Spock"
    }

    def "use cleanup: to delete a file"() {
        given:
        def file = new File("temp_test_solution.txt")

        when:
        file.write("test content")

        then:
        file.exists()
        file.text == "test content"

        cleanup:
        file.delete()
    }

    def "use filter: to test a subset of data"() {
        expect:
        number > 5

        where:
        number << (1..10)

        filter:
        number > 5
    }
}
