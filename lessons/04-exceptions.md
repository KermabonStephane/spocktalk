# Lesson 4: Exception Handling

In this lesson, we will learn how to verify that your code throws the expected exceptions using Spock.

---

## The `thrown()` and `thrown(Class)` Methods

Spock provides a very clean way to catch and verify exceptions in the `then:` block.

### 1. Simple Exception Verification

Use `thrown(Class)` to assert that a specific exception type was thrown during the `when:` block.

```groovy
def "should throw exception for negative index"() {
    given:
    def fibonacci = new Fibonacci()

    when:
    fibonacci.of(-1)

    then:
    thrown(FibonacciException)
}
```

### 2. Accessing the Exception Instance

If you need to verify properties of the exception (like the message or a status code), you can capture the exception instance using `thrown()`.

```groovy
def "should throw exception with specific message"() {
    given:
    def sequence = new FibonacciSequence(new Fibonacci())

    when:
    sequence.getSequence(-1, 0)

    then:
    FibonacciSequenceException e = thrown()
    e.message == "start and end must be positives"
}
```

### 3. Asserting that NO Exception is thrown

While Spock tests pass by default if no exception occurs, you can be explicit using `notThrown(Class)`. This is mostly useful for documentation or specifically asserting that a certain exception type was avoided.

```groovy
then:
notThrown(NullPointerException)
```

---

## Exercise Time! 🚀

Open `src/test/groovy/org/demis27/exception/ExerciceExceptionSpec.groovy`.

1.  Implement a test that verifies `Fibonacci.of(-3)` throws a `FibonacciException`.
2.  Implement a test that verifies `FibonacciSequence.getSequence(-1, 0)` throws a `FibonacciSequenceException` AND check that the message is exactly `'start and end must be positives'`.

---
[<- Previous Lesson: Stubs, Mocks, and Spies](./03-stubs-mocks-spies.md) | [Next Lesson: Lifecycle and Parallelism ->](./05-lifecycle-parallelism.md)
