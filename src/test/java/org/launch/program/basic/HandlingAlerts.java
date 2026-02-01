package org.launch.program.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
        page.onDialog(dialog->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();
            System.out.println(dialog.message());
        });
        page.locator("[type='submit']").click();
        Thread.sleep(3000);
    }
}
