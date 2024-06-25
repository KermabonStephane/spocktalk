package org.demis27;

public class PartialMock {

    protected int doMultiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b) {
        return doMultiply(a, b);
    }
}
