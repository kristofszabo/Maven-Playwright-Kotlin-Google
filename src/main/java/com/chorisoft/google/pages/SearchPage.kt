package com.chorisoft.google.pages

import com.chorisoft.google.MainPage
import com.microsoft.playwright.Page

class SearchPage(page: Page) : MainPage(page) {
    val searchBar = page.locator("#q")

}