package org.demis27;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirtyTest {

    @SneakyThrows
    @Test
    void testFibonacciForTwoValuesAndTestException() {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.of(6);
        Assertions.assertEquals(8, result);
        result = fibonacci.of(5);
        Assertions.assertEquals(5, result);
        Exception exception = Assertions.assertThrows(FibonacciException.class, () -> {
            fibonacci.of(-3);
        });
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci);
        exception = Assertions.assertThrows(FibonacciSequenceException.class, () -> fibonacciSequence.getSequence(-1, 0));
        Assertions.assertEquals("start and end must be positives", exception.getMessage());
    }

}
