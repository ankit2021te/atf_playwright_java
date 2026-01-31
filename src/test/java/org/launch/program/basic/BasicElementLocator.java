package org.launch.program.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicElementLocator {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://gmail.com/");
//        page.locator("#identifierId").fill("trainer@way2automation.com");
        page.type("#identifierId","trainer@way2automation.com",new Page.TypeOptions().setDelay(20));
//        page.click("text=Next");
        page.click("button:has-text('Next')");
    }


}
