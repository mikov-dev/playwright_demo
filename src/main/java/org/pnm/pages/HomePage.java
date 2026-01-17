package org.pnm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.pnm.BasePage;

public class HomePage extends BasePage {

    public Locator getStarted;
    public Locator jsLink;

    public HomePage(Page page) {
        super(page);
        this.getStarted = page.locator("text=Get Started");
        this.jsLink = page.locator("text=JavaScript");
    }

}
