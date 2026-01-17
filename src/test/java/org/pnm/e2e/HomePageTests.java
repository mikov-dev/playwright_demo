package org.pnm.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pnm.BaseTest;
import org.pnm.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTests extends BaseTest {

    HomePage homePage;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(page);
    }

    @Test
    public void verifyPageTitles() {
        assertThat(page).hasTitle("UI Automation Testing Playground");
        assertThat(homePage.pageHeader).containsText("UI Testing Playground");
    }

    @Test
    public void verifySideMenuElements() {
        assertThat(homePage.formElementsLink).isVisible();
        assertThat(homePage.buttonActionsLink).isVisible();
        assertThat(homePage.dataTables).isVisible();
        assertThat(homePage.fileUploads).isVisible();
        assertThat(homePage.alertsAndModals).isVisible();
        assertThat(homePage.dateAndTime).isVisible();
        assertThat(homePage.progressAndLoading).isVisible();
    }

}
