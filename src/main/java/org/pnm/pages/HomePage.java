package org.pnm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.pnm.BasePage;

public class HomePage extends BasePage {

    public Locator formElementsLink;
    public Locator buttonActionsLink;
    public Locator dataTables;
    public Locator fileUploads;
    public Locator alertsAndModals;
    public Locator dateAndTime;
    public Locator progressAndLoading;
    public Locator pageHeader;

    public HomePage(Page page) {
        super(page);
        this.formElementsLink = page.getByTestId("nav-forms");
        this.buttonActionsLink = page.getByTestId("nav-buttons");
        this.dataTables = page.getByTestId("nav-tables");
        this.fileUploads = page.getByTestId("nav-uploads");
        this.alertsAndModals = page.getByTestId("nav-alerts");
        this.dateAndTime = page.getByTestId("nav-calendar");
        this.progressAndLoading = page.getByTestId("nav-progress");
        this.pageHeader = page.getByTestId("site-title");
    }

}
