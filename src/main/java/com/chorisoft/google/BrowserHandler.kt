package com.chorisoft.google

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import java.lang.Exception

object BrowserHandler {
    fun createBrowser(browserTypeName: String): BrowserContext {
        val browserType = getBrowserTypeByName(browserTypeName)
        return browserType.launch(getLaunchOptions(browserType))
            .newContext(
                Browser.NewContextOptions()
                    .setViewportSize(null)
            )
    }

    private fun getLaunchOptions(browserType: BrowserType): BrowserType.LaunchOptions {
        var launchOptions = BrowserType.LaunchOptions().setHeadless(false)
        if (browserType.name().equals("chromium"))
            launchOptions = launchOptions.setArgs(listOf("--start-maximized"))

        return launchOptions
    }

    private fun getBrowserTypeByName(browserType: String): BrowserType {
        var playwright = Playwright.create()
        return when (browserType) {
            "Chrome" -> playwright.chromium()
            "Firefox" -> playwright.firefox()
            "Webkit" -> playwright.webkit()
            else -> throw Exception("Cant find given browser type")
        }
    }
}