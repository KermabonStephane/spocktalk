package org.demis27.simple;

import org.demis27.Fibonacci;
import org.demis27.FibonacciException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleFibonacciTest {

    @Test
    void testFibonacci() throws FibonacciException {
        // given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci();

        // when: 'I call the value for the index 6'
        int result = fibonacci.of(6);

        // then: 'I expected the result is 8'
        Assertions.assertEquals(8, result);
    }

    @Test
    void testFibonacciShort() throws FibonacciException {
        // given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci();

        // expect: 'I expected the result is 8'
        Assertions.assertEquals(8, fibonacci.of(6));
    }
}
