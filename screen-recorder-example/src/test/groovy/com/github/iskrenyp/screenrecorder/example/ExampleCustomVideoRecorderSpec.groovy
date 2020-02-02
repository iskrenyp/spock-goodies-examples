package com.github.iskrenyp.screenrecorder.example

import com.github.iskrenyp.spockscreenrecorder.api.MakeVideo
import geb.spock.GebSpec
import org.openqa.selenium.Keys

// Video recorder may also be applied to whole specifications
// If you want to use the default recorder, just use @MakeVideo
@MakeVideo('myCustomRecorder')
class ExampleCustomVideoRecorderSpec extends GebSpec {

    def "Github home page loads_" () {
        when:
        go 'https://github.com'
        then:
        $("input[name='q']").displayed
    }

    def "The Spock Goodies repo exists on Github__" () {
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
