# Lesson 7: Specification Fields

In Spock, how you declare fields in your `Specification` determines how they are initialized and shared across feature methods. This is essential for managing test state and performance.

---

## 1. Simple Instance Fields (Default)

Any variable declared at the class level without special annotations is an **instance field**.

*   **Behavior**: Spock **re-initializes** these fields before every feature method.
*   **Use Case**: Most of your test data and objects should be instance fields to ensure each test starts with a clean slate (isolation).

```groovy
class MySpec extends Specification {
    String name = "Spock" // Re-initialized before each test
    
    def "test 1"() {
        when: name = "Kirk"
        then: name == "Kirk"
    }
    
    def "test 2"() {
        expect: name == "Spock" // Back to original value
    }
}
```

---

## 2. Shared Fields (`@Shared`)

Sometimes you have objects that are expensive to create (like a database connection) or that you want to share across all tests. Use the `@Shared` annotation.

*   **Behavior**: These fields are initialized **once** before the first feature method and are shared by all feature methods.
*   **Use Case**: Heavyweight objects, caches, or shared test state.

```groovy
class MySpec extends Specification {
    @Shared Database db = new Database() // Initialized once
    
    def "test 1"() {
        expect: db.isConnected()
    }
}
```

---

## 3. Constant Fields (`static final`)

Just like in Java, you can define constants using `static final`.

*   **Behavior**: These belong to the class itself, not instances. They are initialized when the class is loaded.
*   **Use Case**: Fixed values, configuration constants, or reused strings/numbers that never change.

```groovy
class MySpec extends Specification {
    static final String API_URL = "https://api.example.com"
    
    def "test"() {
        expect: API_URL.startsWith("https")
    }
}
```

---

## Exercise: Working with Fields 🛠️

Now it's your turn to practice using these three types of fields.

1.  Open `ExerciceFieldSpec.groovy` in the `org.demis27.fixture` package.
2.  Implement the fields as described in the comments.
3.  Add tests to verify the behavior (especially the re-initialization of simple fields vs. shared fields).

## Summary of the Journey 🏁

Congratulations! You have completed the Spock Framework tutorial. You now know:
*   How to write **Specifications** and use **BDD blocks** (`given`, `when`, `then`, `expect`).
*   How to perform **Data-Driven testing** to cover multiple scenarios with minimal code.
*   How to use **Stubs, Mocks, and Spies** to isolate your code and verify interactions.
*   How to handle **Exceptions** gracefully.
*   How to manage the **Lifecycle** and **Parallelism** of your tests.
*   How **Inheritance** affects the execution of your test fixtures.
*   How to use **Fields** (`Simple`, `@Shared`, `static final`) to manage test state.

Happy testing with Spock! 🖖

---
[<- Previous Lesson: Fixture Inheritance and Execution Order](./06-inheritance-order.md) | [Home](../README.md)
