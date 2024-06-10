package org.demis27;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FibonacciSequence {

    private final Fibonacci fibonacci;

    public FibonacciSequence(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    public List<Integer> getSequence(int start, int end) throws FibonacciSequenceException {
        if (start < 0 || end < 0) {
            throw new FibonacciSequenceException("start and end must be positives");
        }
        if (start > end) {
            throw new FibonacciSequenceException("end must be greater or equals than start");
        }
        List<Integer> result = new ArrayList<>(end - start);

        IntStream.rangeClosed(start, end).forEach(value -> {
            try {
                result.add(fibonacci.getSequenceValue(value));
            } catch (FibonacciException e) {
                // nothing to do
            }
        });

        return result;
    }
}
