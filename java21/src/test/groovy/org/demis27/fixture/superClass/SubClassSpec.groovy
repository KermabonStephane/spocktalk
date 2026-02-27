package org.demis27.fixture.superClass

import groovy.util.logging.Slf4j
import spock.lang.Shared

@Slf4j
class SubClassSpec extends SuperClassSpec {

    @Shared Integer d = 1
    static Integer e = 1
    Integer f = 1

    def setupSpec() {
        log.debug("Sub class setupSpec")
    }

    def setup() {
        log.debug("Sub class setup")
    }

    def cleanup() {
        log.debug("Sub class cleanup")
    }

    def cleanupSpec() {
        log.debug("Sub class cleanupSpec")
    }

    def 'test' () {
        log.debug("Fixture")
        expect:
        true
    }
}
