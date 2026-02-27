package org.demis27.fixture


import spock.lang.Specification

class ExerciseFieldSpec extends Specification {

    // TODO: Declare a simple field 'counter' initialized to 0
    // This field should be re-initialized before each feature method.

    // TODO: Declare a @Shared field 'sharedCounter' initialized to 0
    // This field should be shared across all feature methods.

    // TODO: Declare a static final field 'PI' with value 3.14

    def "simple field is re-initialized"() {
        expect:
        // TODO: assert counter is 0
        true

        when:
        // TODO: increment counter
        true

        then:
        // TODO: assert counter is 1
        true
    }

    def "simple field is re-initialized again"() {
        expect:
        // TODO: assert counter is 0 (showing it was reset)
        true
    }

    def "shared field is NOT re-initialized"() {
        expect:
        // TODO: assert sharedCounter is 0
        true

        when:
        // TODO: increment sharedCounter
        true

        then:
        // TODO: assert sharedCounter is 1
        true
    }

    def "shared field keeps its value"() {
        expect:
        // TODO: assert sharedCounter is 1 (showing it was NOT reset)
        true
    }

    def "constant field is available"() {
        expect:
        // TODO: assert PI is 3.14
        true
    }
}
