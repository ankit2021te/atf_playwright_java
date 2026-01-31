package org.launch.program.basic;

import com.microsoft.playwright.*;

public class LinksPresentInPage {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        Locator links = page.locator("a");
        System.out.println("links count: "+links.count());
        for (int i=0;i<links.count();i++){
            System.out.println("text: "+links.nth(i).innerText()+" and href value is: "+links.nth(i).getAttribute("href"));
        }
    }
}
