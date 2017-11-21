package com.eodessa.pages

import com.eodessa.model.Constants
import geb.Page

class FeaturesPage extends Page {
    static url = Constants.BASE_URL

    static at = {
        title == 'Push Notification Marketing Features'
    }

    static content = {
        lnkRequestADemoPage { $("a", text: iContains("Request a demo")) }
    }

    void clickLinkByName(String linkName){
        $("a", text: iContains(linkName)).click()
    }
}
