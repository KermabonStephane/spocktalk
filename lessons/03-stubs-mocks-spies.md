# Lesson 3: Stubs, Mocks, and Spies

In this lesson, we will explore Spock's built-in support for interaction testing using Stubs, Mocks, and Spies.

---

## 1. Stubs

A **Stub** is used to provide canned answers to calls made during a test. It is used when you want the object to return specific values but don't care about the interactions (how many times it was called, with what arguments, etc.).

```groovy
given:
Fibonacci fibonacci = Stub()
fibonacci.of(_) >> 8 // Return 8 for any input
```

*   `>>` defines a fixed return value.
*   `>>>` defines a sequence of return values for successive calls (e.g., `>>> [0, 1, 1, 2]`).
*   `_` is a wildcard matching any argument.

## 2. Mocks

A **Mock** is used to verify interactions. You use it when you want to make sure that a specific method was called a certain number of times with certain arguments.

```groovy
given:
Fibonacci fibonacci = Mock()

when:
service.doSomething(fibonacci)

then:
1 * fibonacci.of(6) // Verify 'of(6)' was called exactly once
```

*   `n * object.method(args)` is the syntax for cardinality.
*   Mocks can also act as stubs: `1 * fibonacci.of(6) >> 8`.

## 3. Spies

A **Spy** is a wrapper around a **real object**. By default, calls to a Spy are forwarded to the real instance. You use it when you want to track or partially override the behavior of an existing object.

```groovy
given:
Fibonacci fibonacci = Spy() // Wraps a real Fibonacci instance

when:
fibonacci.of(2)

then:
1 * fibonacci.of(2) // Interaction trackable, code still executes real logic
```

## 4. Partial Mocking

Partial mocking is achieved using a **Spy**. You can override specific methods while letting others run their original implementation.

```groovy
given:
PartialMock partialMock = Spy {
    doMultiply(_, _) >> 6 // Override this method
}

expect:
partialMock.multiply(2, 3) == 6 // multiply() calls doMultiply(), which is stubbed
```

---

## Exercise Time! 🚀

### Exercise 1: Stubs & Mocks
Open `src/test/groovy/org/demis27/stubMockAndSpy/ExerciceStubSequenceSpec.groovy`.
You will test the `FibonacciSequence` class, which depends on a `Fibonacci` object.
*   Implement a test using a **Stub** to provide values.
*   Implement a test using a **Mock** to verify interactions.
*   Implement a test combining both.

### Exercise 2: Partial Mocks
Open `src/test/groovy/org/demis27/stubMockAndSpy/ExercicePartialMockSpec.groovy`.
Use a **Spy** to override the `doMultiply` method and verify that the `multiply` method uses your stubbed value.

---
[<- Previous Lesson: Data-Driven Testing](./02-data-driven.md) | [Next Lesson: Exceptions ->](./04-exceptions.md) (Coming soon!)
