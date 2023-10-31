package com.chorisoft.google.test

import com.chorisoft.google.BrowserHandler
import com.chorisoft.google.Config
import com.chorisoft.google.PageHandler
import com.chorisoft.google.pages.CommonPage
import org.testng.Assert
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class CookiesPanelTest {
    val commonPage : CommonPage = PageHandler(BrowserHandler.createBrowser(Config.browser).pages().get(0)).commonPage

    @Test
    fun acceptCookiesTest(){
        commonPage.cookiePanel.acceptCookies()
        Assert.assertFalse(commonPage.cookiePanel.isCookiesWindowVisible());
    }
}