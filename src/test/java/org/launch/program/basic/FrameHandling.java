package org.launch.program.basic;

import com.microsoft.playwright.*;

public class FrameHandling {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        FrameLocator frame1 = page.frameLocator("id=iframeResult");
                frame1.locator("button:has-text('Try it')").click();
    }
}
