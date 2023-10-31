package com.chorisoft.google

import com.chorisoft.google.pages.CommonPage
import com.microsoft.playwright.Page

class PageHandler(private val page: Page) {
    val commonPage: CommonPage = CommonPage(page)
}