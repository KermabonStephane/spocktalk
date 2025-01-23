package org.demis27.fixture

import org.demis27.Fibonacci
import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Execution
import spock.lang.Shared
import spock.lang.Specification

// Specification
// JUnit Test class
@Execution(ExecutionMode.SAME_THREAD)
class FibonacciFixtureSpec extends Specification {
    // ---------------------------
    // Fields
    // ---------------------------
    // Simple field, always re-initialized before each feature
    String hello = 'HELLO'
    // Shared fields between test
    @Shared Fibonacci fibonacci = new Fibonacci()
    // Constant fields
    static String WORLD = 'World'

    // ---------------------------
    // Fixture methods
    // ---------------------------

    // runs once -  before the first feature method
    // JUnit 5 @BeforeAll
    def setupSpec() {
    }

    // runs before every feature method
    // JUnit 5 @BeforeEach
    def setup() {
    }

    // runs after every feature method
    // JUnit @After
    def cleanup() {
    }

    // runs once -  after the last feature method
    // JUnit @AfterClass
    def cleanupSpec() {
    }

    // ---------------------------
    // feature methods
    // ---------------------------

    // JUnit @Test
    def 'test fibonacci'() {
        // given, when, then, expect, cleanup, and where
        expect:
        equals(fibonacci.of(5), 5)
    }

    def 'test simple field'() {
        expect:
        hello == 'HELLO'
    }

    def 'test modify simple field'() {
        when:
        hello = 'GOODBYE'

        then:
        hello == 'GOODBYE'
    }

    def 'test not modified simple field'() {
        expect:
        hello == 'HELLO'
    }

    // ---------------------------
    // helper methods
    // ---------------------------
    void 'equals' (result, expected) {
        assert result == expected
    }
}
