package com.eodessa.pages

import com.eodessa.model.Constants
import geb.Page

class ContactPage extends Page {
    static url = Constants.BASE_URL

    static at = {
        title == 'Push Notification Marketing Features Contact Us'
    }

    static content = {
        lnkRequestADemoPage { $("a", text: iContains("Request a demo")) }
        lnkLoginPage { $("a", text: iContains("Features")) }
    }

    void clickLinkByName(String linkName){
        $("a", text: iContains(linkName)).click()
    }
}
