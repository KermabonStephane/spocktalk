package org.demis27.parallel

import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Execution
import spock.lang.Specification

@Execution(ExecutionMode.SAME_THREAD)
class StackSpec extends Specification {

    static Stack stack

    def setupSpec() {
        stack = new Stack()
        ['One', 'Two', 'Three'].each { it ->stack.push(it)}
    }

    def 'size' () {
        expect:
        stack.size() == 3
    }

    def 'peek' () {
        expect:
        stack.peek() == 'Three'
    }

    def 'pop' () {
        expect:
        stack.pop() == 'Three'
    }

    def 'new size'() {
        expect:
        stack.size() == 2
    }
}
