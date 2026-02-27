package org.demis27.stubMockAndSpy

import org.demis27.PartialMock
import spock.lang.Specification

class ExercicePartialMockSpec extends Specification {

    def 'partial mock with Spy'() {
        given: 'Add a partial mock on the PartialMock object using a Spy'
        // TODO: Create a Spy of PartialMock and override 'doMultiply' to return 6

        when: 'Call the multiply method'
        // TODO: call partialMock.multiply(1, 2)

        then: 'result as expected by the stub value on the spy'
        // TODO: verify result is 6
    }
}
