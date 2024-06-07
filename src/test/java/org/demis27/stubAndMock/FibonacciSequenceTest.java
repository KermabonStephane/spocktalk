package org.demis27.stubAndMock;

import lombok.SneakyThrows;
import org.demis27.Fibonacci;
import org.demis27.FibonacciSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class FibonacciSequenceTest {

    @SneakyThrows
    @Test
    void fibonacciSequenceStubTest() {
        // given:
        Fibonacci fibonacci = Mockito.mock(Fibonacci.class);
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci);

        // and: 'stub fibonacci'
        Mockito.when(fibonacci.getSequenceValue(Mockito.anyInt())).thenReturn(0, 1, 1);

        // when:
        List<Integer> sequence = fibonacciSequence.getSequence(0, 2);

        // then:
        Assertions.assertIterableEquals(List.of(0, 1, 1), sequence);
    }

    @SneakyThrows
    @Test
    void fibonacciSequenceMockTest () {
        // given:
        Fibonacci fibonacci = Mockito.mock(Fibonacci.class);
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci);

        // and:
        Mockito.when(fibonacci.getSequenceValue(Mockito.anyInt())).thenReturn(0, 1, 1);

        // when:
        List<Integer> sequence = fibonacciSequence.getSequence(0, 2);

        // then:
        Mockito.verify(fibonacci, Mockito.times(3)).getSequenceValue(Mockito.anyInt());
        Assertions.assertIterableEquals(List.of(0, 1, 1), sequence);
    }

    @SneakyThrows
    @Test
    void fibonacciSequenceMockAndStubTest () {
        // given:
        Fibonacci fibonacci = Mockito.mock(Fibonacci.class);
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacci);

        // when:
        fibonacciSequence.getSequence(0, 2);

        // then:
        Mockito.verify(fibonacci, Mockito.times(3)).getSequenceValue(Mockito.anyInt());
    }

    @SneakyThrows
    @Test
    void fibonacciSequenceSpyTest (){
        // given:
        Fibonacci fibonacci = new Fibonacci();
        Fibonacci spy = Mockito.spy(fibonacci);
        FibonacciSequence fibonacciSequence = new FibonacciSequence(spy);

        // when:
        fibonacciSequence.getSequence(0, 2);

        // then:
        Mockito.verify(spy, Mockito.times(2)).getSequenceValue(0);
        Mockito.verify(spy, Mockito.times(2)).getSequenceValue(1);
        Mockito.verify(spy, Mockito.times(1)).getSequenceValue(2);
    }

}
