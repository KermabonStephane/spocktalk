package org.demis27.simple

import spock.lang.Ignore
import spock.lang.Specification

class ExerciseMoreBlocksSpec extends Specification {

    // TODO: remove the @Ignore
    @Ignore
    def "use and: block for readability"() {
        given: "a message"
        def msg = "Hello"

        // TODO: use and: to define another variable 'name' with value "Spock"

        when: "we combine them"
        def result = "$msg $name"

        then: "the result is correct"
        result == "Hello Spock"
    }

    def "use cleanup: to delete a file"() {
        given:
        def file = new File("temp_test.txt")

        when:
        file.write("test content")

        then:
        file.exists()
        file.text == "test content"

        // TODO: use cleanup: to delete the file
    }

    // TODO: remove the @Ignore
    @Ignore
    def "use filter: to test a subset of data"() {
        expect:
        number > 5

        where:
        number << (1..10)

        // TODO: use filter: to only run iterations where number > 5
    }
}
