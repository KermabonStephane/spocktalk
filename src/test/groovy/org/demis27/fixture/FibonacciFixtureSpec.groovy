package org.demis27.fixture

import org.demis27.Fibonacci
import spock.lang.Shared
import spock.lang.Specification

// Specification
// JUnit Test class
class FibonacciFixtureSpec extends Specification {
    // ---------------------------
    // Fields
    // ---------------------------
    // Simple field
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
        equals(fibonacci.getSequenceValue(5), 5)
    }

    def 'test simple field'() {
        expect:
        hello == 'HELLO'
    }


    def 'test modified simple field'() {
        expect:
        hello == 'GOODBYE'
    }

    // ---------------------------
    // helper methods
    // ---------------------------
    void 'equals' (result, expected) {
        assert result == expected
    }
}
