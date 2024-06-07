package org.demis27.exception;

import org.demis27.Fibonacci;
import org.demis27.FibonacciException;
import org.demis27.FibonacciSequence;
import org.demis27.FibonacciSequenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciExceptionTest {

    @Test
    public void testFibonacciException() {
        // Given: a fibonacci object
        Fibonacci fibonacci = new Fibonacci();

        // When:
        Exception exception = Assertions.assertThrows(FibonacciException.class, () -> {
            fibonacci.getSequenceValue(-3);
        });
    }

    @Test
    public void testFibonacciSequenceException() {
        // Given: a fibonacci object
        Fibonacci fibonacci = new Fibonacci();
        // And: a fibonacci sequence
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci);

        // When:
        Exception exception = Assertions.assertThrows(FibonacciSequenceException.class, () -> fibonacciSequence.getSequence(-1, 0));

        // Then
        Assertions.assertEquals("start and end must be positives", exception.getMessage());
    }

}
