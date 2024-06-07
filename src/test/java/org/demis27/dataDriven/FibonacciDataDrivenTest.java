package org.demis27.dataDriven;

import lombok.SneakyThrows;
import org.demis27.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciDataDrivenTest {

    @SneakyThrows
    @ParameterizedTest
    @CsvSource(value = {"3,2", "4,3", "5,5", "6,8"})
    void fibonacciDataDriventTest(int input, int  expected) {
        // given: 'I create a Fibonacci object'
        Fibonacci fibonacci = new Fibonacci();

        // when: 'I call the value for the input index'
        int result = fibonacci.getSequenceValue(input);

        // then: 'The result is as expected'
        Assertions.assertEquals(expected, result);
    }

}
