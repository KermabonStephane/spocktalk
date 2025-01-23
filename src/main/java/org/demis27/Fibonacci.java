package org.demis27;

public class Fibonacci {

    public int of(int sequenceIndex) throws FibonacciException {
        if (sequenceIndex < 0) {
            throw new FibonacciException(
                    String.format("%d is negative, fibonacci sequence start at zero", sequenceIndex));
        }
        if (sequenceIndex == 0) {
            return 0;
        }
        if (sequenceIndex == 1) {
            return 1;
        }
        return of(sequenceIndex -1)
                + of(sequenceIndex - 2);
    }
}