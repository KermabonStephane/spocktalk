package org.demis27.annotation;

import org.demis27.Fibonacci;
import org.junit.jupiter.api.*;

import lombok.SneakyThrows;

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
    static void cleanupAll() {
        fibonacci = null;
    }

    @Test
    @SneakyThrows
    void testFibonacci() {
        // given, when, then, expect, cleanup, and where
        Assertions.assertEquals(fibonacci.of(5), 5);
    }
}
