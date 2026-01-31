package org.launch.program.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class HandlingDropDowns {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        page.selectOption("select","et");
        //select by text
        page.selectOption("select", new SelectOption().setLabel("Eesti"));
        // select by index
        page.selectOption("select",new SelectOption().setIndex(1));
    }
}
