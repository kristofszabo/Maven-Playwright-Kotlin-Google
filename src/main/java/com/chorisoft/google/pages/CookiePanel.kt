package com.chorisoft.google.pages

import com.chorisoft.google.PageObject
import com.microsoft.playwright.Locator

class CookiePanel(host: Locator) : PageObject(host) {
    private val acceptButton: Locator = host.locator("//*[text() = 'Az összes elfogadása']")

    fun acceptCookies() {
        acceptButton.click()
    }

    fun isCookiesWindowVisible(): Boolean {
        return host.isVisible
    }
}