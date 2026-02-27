package org.demis27.stubMockAndSpy

import org.demis27.PartialMock
import spock.lang.Specification

class PartialMockSpec extends Specification {

    def 'partial mock with Spy'() {
        given: 'Add a partial mock on the PartialMock object'
        PartialMock partialMock = Spy {
            doMultiply(_,_) >> 6
        }

        when: 'Call the multiply'
        def result = partialMock.multiply(1, 2)

        then: 'result as expected by the stub value on the spy'
        6 == result
    }

}
