# Lesson 2: Data-Driven Testing

In Lesson 1, we learned about the basic blocks of a Spock specification. In this lesson, we will see one of Spock's most powerful features: **Data-Driven Testing**.

Data-driven testing allows you to run the same test logic multiple times with different sets of data.

---

## The `where:` Block

The `where:` block is used to define the data sets for your feature method. It always comes last in the method.

### 1. Data Tables

The most readable way to provide data is using a **Data Table**.

```groovy
def "should calculate fibonacci values"() {
    expect:
    fibonacci.of(input) == expected

    where:
    input || expected
    3     || 2
    4     || 3
    5     || 5
}
```

*   The first line of the table defines the names of the variables (`input` and `expected`).
*   The `||` (or `|`) separator is used to distinguish between input columns and expected result columns (though `|` can be used everywhere, `||` is a common convention to separate inputs from outputs visually).

### 2. Variable Interpolation in Method Names

When running a data-driven test, Spock treats each row as a separate iteration. To make the test report clearer, you can use variables from the `where:` block directly in the method name:

```groovy
def "fibonacci of #input should be #expected"() {
    expect:
    new Fibonacci().of(input) == expected

    where:
    input | expected
    6     | 8
    7     | 13
}
```
Spock will "unroll" this into multiple tests in your IDE and test reports:
* `fibonacci of 6 should be 8`
* `fibonacci of 7 should be 13`

---

### 3. Data Pipes

You can also use the "left shift" operator (`<<`) to feed data from any `Iterable` (Lists, Ranges, etc.).

```groovy
where:
input << [3, 4, 5]
expected << [2, 3, 5]
```

---

## Complex Objects in Data Tables

Data tables aren't limited to primitives. You can use any Groovy expression, including constructor calls or method calls.

```groovy
where:
input                     || expectedResult
LocalDate.of(2024, 6, 21) || LocalDate.of(2024, 6, 22)
```

---

## Exercise Time! 🚀

### Exercise 1: Standard Data Driven
Open `src/test/groovy/org/demis27/dataDriven/ExerciceDataDrivenSpec.groovy`.
Implement the `test fibonacci - data table` method using a `where:` block with a data table containing several Fibonacci values.

### Exercise 2: Object-Based Data Driven
Open `src/test/groovy/org/demis27/dataDriven/ExerciceDateDataDrivenSpec.groovy`.
In this exercise, you will test the `plusDays(1)` method of `java.time.LocalDate`. Use a data table to verify transitions like leap years or month ends.

---
[<- Previous Lesson: Spock Blocks](./01-blocks.md) | [Next Lesson: Exceptions ->](./03-exceptions.md) (Coming soon!)
