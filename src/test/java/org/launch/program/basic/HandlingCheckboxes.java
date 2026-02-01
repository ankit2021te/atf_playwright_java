package org.launch.program.basic;

import com.microsoft.playwright.*;

public class HandlingCheckboxes {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");
//        Locator displayElement = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");
//        Locator displayCheckboxes = displayElement.locator("[type='checkbox']");
        Locator displayElement = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");
        Locator displayCheckboxes = displayElement.locator("[type='checkbox']");
        System.out.println(displayCheckboxes.count());
        for (int i=0;i<displayCheckboxes.count();i++){
            displayCheckboxes.nth(i).click();
        }

    }
}
