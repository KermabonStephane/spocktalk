# Lesson 5: Lifecycle and Parallelism

In this lesson, we will understand how Spock manages the execution of your tests and how to control parallelism.

---

## 1. The Spock Lifecycle

A Spock `Specification` has a well-defined lifecycle. Understanding this is crucial for managing test state.

### Fixture Methods

1.  **`setupSpec()`**: Runs **once** before the first feature method. Ideal for expensive setup like starting a database. (Similar to JUnit 5 `@BeforeAll`).
2.  **`setup()`**: Runs **before every** feature method. Use it to reset state before each test. (Similar to JUnit 5 `@BeforeEach`).
3.  **`cleanup()`**: Runs **after every** feature method. (Similar to JUnit 5 `@AfterEach`).
4.  **`cleanupSpec()`**: Runs **once** after all feature methods have finished. (Similar to JUnit 5 `@AfterAll`).

### Fields and State

*   **Instance Fields**: Variables declared in the class (like `def name = "Spock"`) are **automatically re-initialized** before every feature method. This ensures test isolation.
*   **`@Shared` Fields**: Variables annotated with `@Shared` (like `@Shared def db = connect()`) are initialized **once** and shared across all feature methods in the specification.
*   **Static Fields**: Like Java, `static` fields are shared across all instances. However, `@Shared` is preferred in Spock as it works better with its lifecycle.

---

## 2. Order of Execution

By default, Spock executes feature methods in the order they appear in the file.

If you have a shared state (like a `@Shared` list or a `static` stack), the order of execution matters. Look at `parallel/SolutionStackSpec.groovy`:

```groovy
@Execution(ExecutionMode.SAME_THREAD)
class SolutionStackSpec extends Specification {
    static Stack stack
    
    def setupSpec() {
        stack = new Stack()
        ['One', 'Two', 'Three'].each { stack.push(it) }
    }

    def 'size'() { expect: stack.size() == 3 }
    def 'pop'()  { expect: stack.pop() == 'Three' }
    def 'new size'() { expect: stack.size() == 2 }
}
```

In `SAME_THREAD` mode, these tests run sequentially. If `size` runs before `pop`, it passes. If `pop` runs, then `new size` passes.

---

## 3. Parallelism

Spock allows you to control how tests are executed using the `@Execution` annotation.

### Execution Modes

1.  **`ExecutionMode.SAME_THREAD`** (Default):
    *   Tests in the same Specification run one after another.
    *   Predictable for shared state.
2.  **`ExecutionMode.CONCURRENT`**:
    *   Tests can run in parallel.
    *   **Warning**: If your tests share state (like the `static Stack` above), they will likely fail or cause flaky behavior because they interfere with each other!

### How to use it:

```groovy
import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Execution

@Execution(ExecutionMode.CONCURRENT)
class MyParallelSpec extends Specification {
    // ...
}
```

---

## Exploration 🔍

There is no formal exercise for this lesson. Instead, we invite you to:

1.  Open `java17/src/test/groovy/org/demis27/parallel/SolutionStackSpec.groovy`.
2.  Run the tests. They should pass because they are in `SAME_THREAD`.
3.  Change the annotation to `@Execution(ExecutionMode.CONCURRENT)`.
4.  Run the tests again multiple times. Observe how they might fail because `pop()` and `size()` are fighting for the same static object.
5.  Open `java17/src/test/groovy/org/demis27/fixture/SolutionFibonacciFixtureSpec.groovy` to see a complete example of fixtures and field management.

---
[<- Previous Lesson: Exception Handling](./04-exceptions.md) | [Next Lesson: Fixture Inheritance and Execution Order ->](./06-inheritance-order.md)
