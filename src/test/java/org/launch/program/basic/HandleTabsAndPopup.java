package org.launch.program.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleTabsAndPopup {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        Page popup=page.waitForPopup(()->{
            page.locator("text=Privacy Policy").nth(0).click();
        });
        popup.locator("id=header-sign-up-btn").click();
        popup.locator("id=name").fill("Ankit Singh");

        popup.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
