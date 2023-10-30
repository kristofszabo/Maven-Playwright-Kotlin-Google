package com.chorisoft.google

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Playwright
import java.lang.Exception

fun main(args: Array<String>) {
    print("Hello world")
    print(System.getProperty("baseUrl"))
    var playwright = Playwright.create();

    val browser = createBrowser("Webkit")
    val page = browser.newPage()
    page.navigate(Config.baseUrl)

    page.waitForLoadState()
    playwright.close();
}

fun createBrowser(browserTypeName: String): Browser {
    val browserType = getBrowserTypeByName(browserTypeName)
    return browserType.launch(getLaunchOptions(browserType))
}

fun getLaunchOptions(browserType: BrowserType): LaunchOptions {
    return LaunchOptions().setHeadless(false)
    //Maybe args should set for different full screen
    //Maybe run in private browser
}

fun getBrowserTypeByName(browserType: String): BrowserType {
    var playwright = Playwright.create()
    return when (browserType) {
        "Chrome" -> playwright.chromium()
        "Firefox" -> playwright.firefox()
        "Webkit" -> playwright.webkit()
        else -> throw Exception("Cant find given browser type")
    }
}