package com.eodessa.steps

import com.eodessa.pages.FeaturesPage
import com.eodessa.pages.IndexPage
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import geb.Browser
import geb.Page

this.metaClass.mixin(EN)
this.metaClass.mixin(Hooks)

Given(~/^(?:the |a )?(?:(?:MarketSource )?rep(?:resentative)?|customer) come to home page$/) { ->
    Browser.drive {
        to (IndexPage)
    }
    println("Come to home page "+"\n")
}
And(~/^the customer navigates to Features Page$/) { ->
    Browser.drive {
        Page page = at IndexPage
        page.lnkFeaturesPage.click()
    }
    println("Navigated to Features Page " + "\n")
}
And (~/^Request a demo$/){->
    println("Request a demo")
    Browser.drive {
        Page page = at FeaturesPage
        page.lnkRequestADemoPage.click()
    }

}