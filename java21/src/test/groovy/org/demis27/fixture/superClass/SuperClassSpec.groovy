package org.demis27.fixture.superClass

import groovy.util.logging.Slf4j
import spock.lang.Shared
import spock.lang.Specification

@Slf4j
class SuperClassSpec extends Specification {

    @Shared Integer a = 1
    static Integer b = 1
    Integer c = 1

    def setupSpec() {
        log.debug("Super class setupSpec")
    }

    def setup() {
        log.debug("Super class setup")
    }

    def cleanup() {
        log.debug("Super class cleanup")
    }

    def cleanupSpec() {
        log.debug("Super class cleanupSpec")
    }
}
