package com.chorisoft.google.pages

import com.chorisoft.google.MainPage
import com.microsoft.playwright.Page

class CommonPage(page: Page) : MainPage(page) {
    var cookiePanel: CookiePanel =
        CookiePanel(page.locator("//h1[contains(text(), 'Mielőtt továbblép a Google-ra')]/ancestor::span"))
}