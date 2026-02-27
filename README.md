# Spock Talk Exercises

Welcome to the **Spock Framework** exercises repository. This project is designed to help you learn and practice the [Spock Framework](https://spockframework.org/) for Java testing.

## Project Structure

This repository is organized into three main versions, each targeting a specific Java version:

- **[java17](./java17)**: Exercises compatible with Java 17.
- **[java21](./java21)**: Exercises compatible with Java 21.
- **[java25](./java25)**: Exercises compatible with Java 25.

Each version contains the same set of exercises but is configured to run on the respective Java Runtime.

## Lessons

Start your journey here:
- **[Lesson 1: Spock Blocks (Given, When, Then, Expect)](./lessons/01-blocks.md)**
- **[Lesson 2: Data-Driven Testing](./lessons/02-data-driven.md)**

## How to use this repository

### Spock Exercises

For each topic, you will find two files in the `src/test/groovy` directory:
- **`ExerciceXXXSpec.groovy`**: This is the file you should complete. It contains placeholders or failing tests that you need to fix.
- **`SolutionXXXSpec.groovy`**: This file contains the solution for the exercise. Use it for reference if you get stuck or to compare your approach.

### JUnit 5 Comparison

For those curious about how the same tests would look in standard JUnit 5, we have included equivalent versions in the `src/test/java` directory.
- A **JUnit version** exists in `src/test/java` for all versions and exercises, allowing you to see the contrast between the Spock DSL and traditional JUnit testing.

## Getting Started

1. Navigate to the directory corresponding to your Java version (e.g., `cd java21`).
2. Run the tests using Maven:
   ```bash
   mvn test
   ```
3. Open the `ExerciceXXXSpec.groovy` file of your choice and start coding!
