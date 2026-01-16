package org.pnm;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://ui-automation-testin-r5md.bolt.host/");
            System.out.println(page.title());
        }
            catch (Exception e) {
            e.printStackTrace();
            }
    }
}
