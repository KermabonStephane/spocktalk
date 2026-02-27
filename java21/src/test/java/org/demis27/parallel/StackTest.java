package org.demis27.parallel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.Stack;

@TestMethodOrder(OrderAnnotation.class)
public class StackTest {

    static Stack stack;

    @BeforeAll
    static void setupSpec() {
        // Create a stack with three elements
        stack = new Stack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
    }

    @Test
    @Order(1)
    void size() {
        // expect: 'They are three elements'
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    @Order(2)
    void peek() {
        // expect: 'The last element is "Three"'
        Assertions.assertEquals("Three", stack.peek());
    }

    @Test
    @Order(3)
    void pop() {
        // expect: 'The last element is "Three", we remove it from stack'
        Assertions.assertEquals("Three", stack.pop());
    }

    @Test
    @Order(4)
    void newSize() {
        // expect: 'They are two elements'
        Assertions.assertEquals(2, stack.size());
    }

}
