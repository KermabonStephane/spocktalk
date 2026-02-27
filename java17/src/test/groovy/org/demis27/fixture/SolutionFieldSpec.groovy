package org.demis27.fixture

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class SolutionFieldSpec extends Specification {

    // Simple field, re-initialized before each feature
    int counter = 0

    // Shared field between test
    @Shared int sharedCounter = 0

    // Constant fields
    static final double PI = 3.14

    def "simple field is re-initialized"() {
        expect:
        counter == 0

        when:
        counter++

        then:
        counter == 1
    }

    def "simple field is re-initialized again"() {
        expect:
        counter == 0
    }

    def "shared field is NOT re-initialized"() {
        expect:
        sharedCounter == 0

        when:
        sharedCounter++

        then:
        sharedCounter == 1
    }

    def "shared field keeps its value"() {
        expect:
        sharedCounter == 1
    }

    def "constant field is available"() {
        expect:
        PI == 3.14
    }
}
