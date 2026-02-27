package org.demis27.parallel

import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Execution
import spock.lang.Specification

@Execution(ExecutionMode.SAME_THREAD)
class StackSpec extends Specification {

    static Stack stack

    def setupSpec() {
        // Create a stack with three elements
        stack = new Stack()
        ['One', 'Two', 'Three'].each { it ->stack.push(it)}
    }

    def 'size' () {
        expect: 'They are three elements'
        stack.size() == 3
    }

    def 'peek' () {
        expect: 'The last element is "Three"'
        stack.peek() == 'Three'
    }

    def 'pop' () {
        expect: 'The last element is "Three", we remove it from stack'
        stack.pop() == 'Three'
    }

    def 'new size'() {
        expect: 'They are two elements'
        stack.size() == 2
    }
}
