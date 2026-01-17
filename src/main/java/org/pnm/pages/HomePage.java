package org.pnm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.pnm.BasePage;

public class HomePage extends BasePage {

    public Locator textInput;

    public HomePage(Page page) {
        super(page);
        this.textInput = page.locator("#text-input");
    }

}
