package org.demis27.annotation;

import org.demis27.Fibonacci;
import org.demis27.FibonacciException;
import org.junit.jupiter.api.*;

public class FibonacciAnnotationTest {

    static Fibonacci fibonacci;

    @BeforeAll
    static void setupAll() {
        fibonacci = new Fibonacci();
    }

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void cleanup() {
    }

    @AfterAll
    static  void cleanupAll() {
        fibonacci = null;
    }

    @Test
    void testFibonacci() throws FibonacciException {
        // given, when, then, expect, cleanup, and where
        Assertions.assertEquals(fibonacci.of(5), 5);
    }
}
