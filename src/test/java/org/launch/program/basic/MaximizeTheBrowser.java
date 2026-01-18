package org.launch.program.basic;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class MaximizeTheBrowser {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        ArrayList<String> argument = new ArrayList<>();
        argument.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(argument));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://www.google.com/");
        System.out.println("Title of the page: "+page.title());

        page.close();
        browser.close();
        playwright.close();
    }
}
