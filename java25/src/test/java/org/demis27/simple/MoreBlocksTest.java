package org.demis27.simple;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MoreBlocksTest {

    @Test
    void useAndBlockEquivalent() {
        // given: a message
        String msg = "Hello";

        // and: a name (just a comment in JUnit)
        String name = "Spock";

        // when: combine them
        String result = msg + " " + name;

        // then: result is correct
        assertEquals("Hello Spock", result);
    }

    @Test
    void useCleanupEquivalent() throws IOException {
        File file = new File("temp_test_junit.txt");
        try {
            // when
            Files.writeString(file.toPath(), "test content");

            // then
            assertTrue(file.exists());
            assertEquals("test content", Files.readString(file.toPath()));
        } finally {
            // cleanup: guaranteed to run
            file.delete();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
    void useFilterEquivalent(int number) {
        // filter: only test numbers > 5
        assumeTrue(number > 5);

        // expect
        assertTrue(number > 5);
    }
}
