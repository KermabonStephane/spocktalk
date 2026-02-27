# Lesson 6: Fixture Inheritance and Execution Order

In this final lesson, we will dive deeper into the Spock lifecycle, specifically how setup and cleanup methods behave when using inheritance.

---

## 1. Inheritance in Spock

When a Specification inherits from another Specification (a super class), Spock automatically calls the fixture methods from **both** classes. You do not need (and should not) call `super.setup()` or `super.setupSpec()` manually.

### Execution Order: Setup

For setup methods, the order goes from the **outside in** (Super class first):

1.  **`super.setupSpec()`**
2.  **`sub.setupSpec()`**
3.  **`super.setup()`**
4.  **`sub.setup()`**
5.  **Feature Method**

### Execution Order: Cleanup

For cleanup methods, the order is reversed, going from the **inside out** (Sub class first):

1.  **Feature Method**
2.  **`sub.cleanup()`**
3.  **`super.cleanup()`**
4.  **`sub.cleanupSpec()`**
5.  **`super.cleanupSpec()`**

---

## 2. Field Initialization and Inheritance

As we learned in Lesson 5, instance fields are re-initialized before every feature method. In an inheritance scenario:

*   **Instance Fields** in the super class are initialized **before** the super class `setup()` method.
*   **`@Shared` Fields** are initialized **once** before the `setupSpec()` methods.

---

## 🔍 Exploration: Observing the Order

To see this behavior in action, we've provided a set of classes with debug logging in `src/test/groovy/org/demis27/fixture/superClass/`:

1.  **`SolutionSuperClassSpec.groovy`**: Defines the base lifecycle methods.
2.  **`SolutionSubClassSpec.groovy`**: Inherits from the above and adds its own logs.

### Steps to Observe:

1.  Run the tests for `SolutionSubClassSpec`.
2.  Look at the console output (or use `mvn test -Dtest=SolutionSubClassSpec`).
3.  You will notice the following interleaved sequence in the logs:
    ```text
    Super class setupSpec
    Sub class setupSpec
    Super class setup
    Sub class setup
    Feature method log (test)
    Sub class cleanup
    Super class cleanup
    Sub class cleanupSpec
    Super class cleanupSpec
    ```

---

## Summary of the Journey 🏁

Congratulations! You have completed the Spock Framework tutorial. You now know:
*   How to write **Specifications** and use **BDD blocks** (`given`, `when`, `then`, `expect`).
*   How to perform **Data-Driven testing** to cover multiple scenarios with minimal code.
*   How to use **Stubs, Mocks, and Spies** to isolate your code and verify interactions.
*   How to handle **Exceptions** gracefully.
*   How to manage the **Lifecycle** and **Parallelism** of your tests.
*   How **Inheritance** affects the execution of your test fixtures.

Happy testing with Spock! 🖖

---
[<- Previous Lesson: Lifecycle and Parallelism](./05-lifecycle-parallelism.md)
