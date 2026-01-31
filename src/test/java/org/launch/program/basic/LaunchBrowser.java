package org.launch.program.basic;

import com.microsoft.playwright.*;

import java.awt.*;

public class LaunchBrowser {

    public static void main(String[] args) {
        System.out.println("Welcome to playwright session");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = dimension.getWidth();
        double height = dimension.getHeight();


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        BrowserContext browserContext =browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));

        Page page = browserContext.newPage();
        page.navigate("https://google.com");
        System.out.println("title of the page: "+page.title());
//        page.close();
//        playwright.close();
    }
}
