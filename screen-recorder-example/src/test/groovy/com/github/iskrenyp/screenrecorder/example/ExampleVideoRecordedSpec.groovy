package com.github.iskrenyp.screenrecorder.example

import com.github.iskrenyp.spockscreenrecorder.api.MakeVideo
import geb.spock.GebSpec
import org.openqa.selenium.Keys

class ExampleVideoRecordedSpec extends GebSpec {

    def "Github home page loads" () {
        when:
        go 'https://github.com'
        then:
        $("input[name='q']").displayed
    }

    // video recorder may be applied to feature methods.
    // If recorder is not specified, the default recorder will be used
    // Alternative: @MakeVideo('myCustomRecorder')
    @MakeVideo
    def "The Spock Goodies repo exists on Github" () {
        when:
        go 'https://github.com'
        and:
        $("input[name='q']").value('spock goodies')
        and:
        $("input[name='q']") << Keys.ENTER
        and:
        $("a[href='/iskrenyp/spock-goodies']").click()
        then:
        waitFor { $("a[title='spock-screen-recorder']").displayed }
    }
}
