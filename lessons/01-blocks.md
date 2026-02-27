# Lesson 1: Spock Blocks (Given, When, Then, Expect)

Welcome to the first lesson! In this lesson, we will explore the fundamental building blocks of a Spock Specification.

## What is a Spock Specification?

A Spock test is called a **Specification**. It is a Groovy class that extends `spock.lang.Specification`. 

```groovy
import spock.lang.Specification

class MyFirstSpec extends Specification {
    // Feature methods go here
}
```

## The Feature Method

Unlike JUnit where methods are usually named `testSomething()`, Spock allows you to use strings for method names, making them much more readable:

```groovy
def "should calculate the Fibonacci value for a given index"() {
    // Blocks go here
}
```

## The Blocks

Spock uses a **Behavior-Driven Development (BDD)** style. A feature method is structured into different blocks.

### 1. `given:` (or `setup:`)
This is where you prepare the context for your test. You initialize objects, set up mocks, or define variables.

### 2. `when:`
This is the stimulus. You perform the action you want to test.

### 3. `then:`
This is the response. You verify the outcome. Every expression in a `then:` block is an **implicit assertion** (except for variable definitions or loop structures).

### Example: Given-When-Then

In `simple/SolutionSimpleSpec.groovy`, you can see this pattern:

```groovy
def 'test fibonacci - then'() {
    given: 'I create a Fibonacci object'
    Fibonacci fibonacci = new Fibonacci()

    when: 'I call the value for the index 6'
    def result = fibonacci.of(6)

    then: 'I expected the result is 8'
    result == 8
}
```

---

### 4. `expect:`
Sometimes, the `when:` and `then:` blocks are so simple that it's cleaner to combine them. The `expect:` block is used for stimulus and response that can be expressed in a single line.

### Example: Given-Expect

Also in `simple/SolutionSimpleSpec.groovy`:

```groovy
def 'test fibonacci - expect'() {
    given: 'I create a Fibonacci object'
    Fibonacci fibonacci = new Fibonacci()

    expect: 'I expected the result is 8'
    fibonacci.of(6) == 8
}
```

## Exercise Time! 🚀

Now it's your turn. Open `src/test/groovy/org/demis27/simple/ExerciceSimpleSpec.groovy` in your chosen Java version directory and implement the two tests using:
1. `given:`, `when:`, `then:` blocks.
2. `given:`, `expect:` blocks.

You should test that `fibonacci.of(6)` returns `8`.

---
[Next Lesson: Data-Driven Testing ->](./02-data-driven.md) (Coming soon!)
