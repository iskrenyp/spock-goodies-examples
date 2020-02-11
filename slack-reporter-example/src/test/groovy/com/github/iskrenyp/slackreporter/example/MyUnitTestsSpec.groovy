package com.github.iskrenyp.slackreporter.example

import com.github.iskrenyp.slackreporter.api.ReportOnSlack
import spock.lang.Specification

@ReportOnSlack('devReporter')
class MyUnitTestsSpec extends Specification {

    def "First passing test case"() {
        expect:
        'Iskren'.reverse() == 'nerksI'
    }

    def "First failing test case" () {
        expect:
        'Iskren'.reverse() == 'Iskren'
    }

    def "Second failing test case" () {
        expect:
        'Iskren'.size() == 7
    }
}
