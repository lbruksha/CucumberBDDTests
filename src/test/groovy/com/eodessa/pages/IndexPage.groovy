package com.eodessa.pages

import com.eodessa.model.Constants
import geb.Page

class IndexPage extends Page {
    static url = Constants.BASE_URL

    static at = {
        title == 'Push Notification Marketing'
    }

    static content = {
        lnkFeaturesPage { $("a", text: iContains("Features")) }
    }

    void clickLinkByName(String linkName){
        $("a", text: iContains(linkName)).click()
    }
}
