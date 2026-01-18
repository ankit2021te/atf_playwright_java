package org.launch.program.basic;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class NonIncognitoWindowTest {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        ArrayList<String> argument = new ArrayList<>();
        argument.add("--start-maximized");
//        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(argument));

        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\prati\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"),new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setArgs(argument)).browser().newContext(new Browser.NewContextOptions().setViewportSize(null));

//        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://www.google.com/");
        System.out.println("title of the page: "+page.title());



    }
}
