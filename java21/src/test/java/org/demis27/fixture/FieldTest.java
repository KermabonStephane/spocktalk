package org.demis27.fixture;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FieldTest {

    // Simple field, re-initialized because JUnit creates a new instance for each
    // test method
    private int counter = 0;

    // Shared field between tests (static)
    private static int sharedCounter = 0;

    // Constant field
    private static final double PI = 3.14;

    @Test
    @Order(1)
    void simpleFieldIsReinitialized() {
        assertEquals(0, counter);
        counter++;
        assertEquals(1, counter);
    }

    @Test
    @Order(2)
    void simpleFieldIsReinitializedAgain() {
        // In JUnit, this is a new instance, so counter is back to 0
        assertEquals(0, counter);
    }

    @Test
    @Order(3)
    void sharedFieldIsNotReinitialized() {
        assertEquals(0, sharedCounter);
        sharedCounter++;
        assertEquals(1, sharedCounter);
    }

    @Test
    @Order(4)
    void sharedFieldKeepsItsValue() {
        // Static variables are shared across test methods
        assertEquals(1, sharedCounter);
    }

    @Test
    @Order(5)
    void constantFieldIsAvailable() {
        assertEquals(3.14, PI);
    }
}
