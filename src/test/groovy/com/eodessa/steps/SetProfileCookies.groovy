package com.eodessa.steps


import cucumber.api.groovy.EN
import geb.Browser

this.metaClass.mixin(EN)

final String GRANT_ALL = "grant all"
final String DENY_ALL = "deny all"
final String NO_OVERRIDE = "no override"

And(~/^user clicks ((?:grant|deny) all|no override) button$/) { String intent ->
    Browser.drive {
        def page = at(SetProfilingCookiesPage)

        switch (intent.toLowerCase()) {
            case GRANT_ALL:
                page.clickGrantAllPermissions()
                break
            case DENY_ALL:
                page.clickDenyAllPermissions()
                break
            case NO_OVERRIDE:
                page.clickNoOverride()
                break
        }
    }
}
Then(~/^the ((?:grant|deny) all|no override) button should be selected$/) { String intent->
    Browser.drive {
        def page = at(SetProfilingCookiesPage)

        switch (intent.toLowerCase()) {
            case GRANT_ALL:
                assert page.btnGrantAllPermissions.isSelected()
                break
            case DENY_ALL:
                assert page.btnDenyAllPermissions.isSelected()
                break
            case NO_OVERRIDE:
                assert page.btnNoOveride.isSelected()
                break
        }
    }
}