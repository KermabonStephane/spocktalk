package org.demis27;

public class Fibonacci {

    public int getSequenceValue(int sequenceIndex) throws FibonacciException {
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
        return getSequenceValue(sequenceIndex -1)
                + getSequenceValue(sequenceIndex - 2);
    }
}