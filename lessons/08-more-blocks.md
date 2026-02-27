# Lesson 8: More Blocks (And, Cleanup, Filter)

In this lesson, we will explore additional Spock blocks that help with readability, resource management, and data filtering.

---

## 1. The `and:` Block

The `and:` block doesn't add new functionality, but it is excellent for readability. It allows you to logically subdivide any other block.

*   **Use Case**: When you have multiple setup steps or multiple assertions and you want to separate them visually.

```groovy
def "test with multiple steps"() {
    given: "a user is logged in"
    def user = login("admin")
    
    and: "a product exists"
    def product = createProduct("Laptop")

    when: "the user adds the product to the cart"
    cart.add(user, product)

    then: "the cart should contain 1 item"
    cart.size() == 1
    
    and: "the total price is correct"
    cart.total() == 1200
}
```

---

## 2. The `cleanup:` Block

The `cleanup:` block is used to release resources (like closing a file, a database connection, or a network socket).

*   **Key Feature**: It is **guaranteed to run**, even if the code before it fails.
*   **Use Case**: Ensuring your test doesn't leave "dirty" state or open resources behind.

```groovy
def "writing to a file"() {
    given:
    def file = new File("test.txt")
    
    when:
    file.write("Hello Spock")
    
    then:
    file.text == "Hello Spock"
    
    cleanup:
    file.delete() // Runs even if the 'then' assertion fails
}
```

---

## 3. The `filter:` Block (Filtering Data)

The `filter:` block works with the `where:` block. It allows you to skip certain iterations of a data-driven test based on a condition.

*   **Behavior**: If the condition in the `filter:` block is false for a row in `where:`, that row is ignored.
*   **Use Case**: Reusing a large data set but only testing a subset of it in a specific feature.

```groovy
def "test only even numbers"() {
    expect:
    number % 2 == 0

    where:
    number << (1..10)

    filter:
    number % 2 == 0 // Only iterations 2, 4, 6, 8, 10 will run
}
```

---

## Exercise: Putting it all together 🛠️

1.  Open `ExerciceMoreBlocksSpec.groovy` in the `org.demis27.simple` package.
2.  Implement a test that uses `and:` to separate log messages.
3.  Implement a test that creates a temporary file and uses `cleanup:` to delete it.
4.  Implement a data-driven test that uses `filter:` to only test indices greater than 5.

## Summary of the Journey 🏁

Congratulations! You have completed the Spock Framework tutorial. You now know:
*   How to write **Specifications** and use **BDD blocks** (`given`, `when`, `then`, `expect`).
*   How to perform **Data-Driven testing** to cover multiple scenarios with minimal code.
*   How to use **Stubs, Mocks, and Spies** to isolate your code and verify interactions.
*   How to handle **Exceptions** gracefully.
*   How to manage the **Lifecycle** and **Parallelism** of your tests.
*   How **Inheritance** affects the execution of your test fixtures.
*   How to use **Fields** (`Simple`, `@Shared`, `static final`) to manage test state.
*   How to use **`and:`**, **`cleanup:`**, and **`filter:`** blocks for better tests.

Happy testing with Spock! 🖖

---
[<- Previous Lesson: Specification Fields](./07-specification-fields.md) | [Home](../README.md)
