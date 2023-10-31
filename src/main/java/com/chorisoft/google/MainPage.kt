package com.chorisoft.google

import com.microsoft.playwright.Page

open class MainPage {
    protected val page: Page

    constructor(page: Page) {
        this.page = page
    }
}