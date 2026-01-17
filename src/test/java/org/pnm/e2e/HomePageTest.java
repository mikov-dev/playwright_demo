package org.pnm.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pnm.BaseTest;
import org.pnm.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(page);
    }

    @Test
    public void verifyTextInput() {
        homePage.textInput.fill("Hello World");
        assertTrue(homePage.textInput.inputValue().equals("Hello World"));
    }

}
